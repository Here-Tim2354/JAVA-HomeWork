import java.util.Scanner;
import java.util.ArrayList;

public class daysInMonth {
    int[] month={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int init;

    public daysInMonth(int init){
        this.init=init;
    }

    public void isLeapyear(){
            this.month[1]=29;
    }

    public ArrayList<Integer> calculator(int init){
        ArrayList<Integer> result=new ArrayList<>();
        result.add(init);
        for(int i=0;i<11;i++){
            init+=month[i];
            result.add(init%7);
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int year=scanner.nextInt();
        int init=scanner.nextInt();
        while(true){
            if(year<=0||init>6||init<0){
                System.out.println("你的输入不正确！请重新输入：");
            }
            else{
                daysInMonth daysInMonth=new daysInMonth(init);
                if(year%4==0&&year%100!=0||year%400==0){
                    daysInMonth.isLeapyear();
                }
                ArrayList<Integer> result=daysInMonth.calculator(init);
                System.out.println(result);
                break;
            }
        }
    }
}
