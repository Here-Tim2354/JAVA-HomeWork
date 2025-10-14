package Practice.Practice2.task1;

import java.util.Scanner;
public class Rectangle {
    double width;
    double height;

    public Rectangle(){
        this.width=1;
        this.height=1;
    }

    public Rectangle(double width,double height){
        this.width=width;
        this.height=height;
    }

    public double getPerimeter(){
        return (width+height)*2;
    }
    public double getArea(){
        return width*height;
    }

    public static void main(String[] args){
        Rectangle rectangle0=new Rectangle();
        System.out.println("默认矩形周长: " + rectangle0.getPerimeter());
        System.out.println("默认矩形面积: " + rectangle0.getArea());

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入矩形的宽度和高度：");
        double width=sc.nextInt();
        double weight=sc.nextInt();
        Rectangle rectangle=new Rectangle(width,weight);
        System.out.println("矩形周长: " + rectangle.getPerimeter());
        System.out.println("矩形面积: " + rectangle.getArea());
        sc.close();
    }
}
