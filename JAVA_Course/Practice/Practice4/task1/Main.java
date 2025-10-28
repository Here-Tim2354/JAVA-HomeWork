package Practice.Practice4.task1;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();

        System.out.println("输入形状类型及参数，并以空格分隔。输入'end'结束：");
        while(sc.hasNext()){
            String shapeType = sc.next();
            // 新增：显式输入 end 时结束循环（忽略大小写）
            if ("end".equalsIgnoreCase(shapeType)) {
                break;
            }
            try{
                switch (shapeType){
                    case "A": //矩形
                        if(!sc.hasNextDouble()) break;
                        double length = sc.nextDouble();
                        if(!sc.hasNextDouble()) break;
                        double width = sc.nextDouble();
                        shapes.add(new Rectangle(length, width));
                        break;
                    case "B": //圆形
                        if(!sc.hasNextDouble()) break;
                        double radius = sc.nextDouble();
                        shapes.add(new Circle(radius));
                        break;
                    case "C": //梯形
                        if(!sc.hasNextDouble()) break;
                        double a = sc.nextDouble();
                        if(!sc.hasNextDouble()) break;
                        double b = sc.nextDouble();
                        if(!sc.hasNextDouble()) break;
                        double h = sc.nextDouble();
                        shapes.add(new Trapezoid(a, b, h));
                        break;
                    default:
                        // 未知形状类型，跳过
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("你的输入有误，请重新输入！");
                sc.nextLine(); // 清除错误输入
            }
        }

        Shape.printInputData(shapes);
        double totalArea = SumOfAreas.sumAreas(shapes);
        System.out.println("面积综合为: " + Shape.df.format(totalArea));
    }
}
