import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
//导入util的实用工具，并创建与文件名相同的public大类
public class UnionFindSet{
    static class UFset{
        //建立两个数组，用于表示结点的连接关系与表示森林中不同树之间的大小
        int[] parent;
        int[] size;

        //建立构造方法，默认每个结点指向自己表示独立一棵树，size数组表示大小
        public UFset(int n){
            parent=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        //这里给出递归实现的Find方法，用于查找一个节点的根节点，并实现路径压缩
        public int Find(int x){
            if(x!=parent[x])
                parent[x]=Find(parent[x]);
            return parent[x];
        }

        //这里给出Union方法，比较输入边的两个端点x,y各自的根节点的树的大小，将小数合并到大树
        public void Union(int x,int y){
            int rootx=Find(x);
            int rooty=Find(y);
            if(rootx!=rooty){
                if(size[rootx]<=size[rooty]){
                    parent[rootx]=rooty;
                    size[rooty]+=size[rootx];
                }
                else{
                    parent[rooty]=rootx;
                    size[rootx]+=size[rooty];
                }
            }
        }
    }
    //主方法，java程序的入口
    public static void main(String[] args){
        //使用Scanner来读取输入，循环读取边的端点并执行合并操作
        Scanner sc=new Scanner(System.in);
        int vertex=sc.nextInt();
        int edge=sc.nextInt();
        //新建UFset对象
        UFset graph=new UFset(vertex);

        for(int i=0;i<edge;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            graph.Union(x,y);
        }

        System.out.println("经过路径压缩后，每个节点对应的根如下：");
        for(int i=0;i<vertex;i++){
            System.out.println(i+"->"+graph.Find(i));
        }

        //使用哈希集读取连通分量个数
        Set<Integer> CCset=new HashSet<>();
        for(int i=0;i<vertex;i++){
            CCset.add(graph.Find(i));
        }
        System.out.println("连通分量的个数有："+CCset.size());

        //使用哈希映射来展示不同连通分量成员
        Map<Integer,ArrayList<Integer>> CComponent=new HashMap<>();
        for(int i=0;i<vertex;i++){
            CComponent.putIfAbsent(graph.Find(i),new ArrayList<>());
            CComponent.get(graph.Find(i)).add(i);
        }
        System.out.println(CCset.size()+"个不同连通分量的成员如下：");
        for(ArrayList<Integer> group:CComponent.values()){
            System.out.println(group);
        }
    }
}