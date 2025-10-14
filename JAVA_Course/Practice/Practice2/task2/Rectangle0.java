package Practice.Practice2.task2;
import Practice.Practice2.task1.Rectangle;
import java.util.Scanner;
public class Rectangle0 extends Rectangle {

    public Rectangle0(){
        super();
    }

    public Rectangle0(double width,double height){
        super(width,height);
    }

    public static void main(String[] args){
        Rectangle0 rectangle00=new Rectangle0();
        System.out.println("默认矩形周长: " + rectangle00.getPerimeter());
        System.out.println("默认矩形面积: " + rectangle00.getArea());

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入矩形的宽度和高度：");
        double width=sc.nextDouble();
        double height=sc.nextDouble();
        Rectangle0 rectangle01=new Rectangle0(width,height);
        System.out.println("矩形周长: " + rectangle01.getPerimeter());
        System.out.println("矩形面积: " + rectangle01.getArea());
    }
}

