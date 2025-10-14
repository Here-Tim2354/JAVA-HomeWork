package Practice.Practice2.task4;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Circle {
    private record Point(double x,double y,double radius){
        public double distanceTo(Point other){
            return Math.hypot(this.x-other.x,this.y-other.y);
        }

        @Override
        public String toString() {
            return String.format("Point[x=%.2f, y=%.2f, radius=%.2f]", x, y, radius);
        }
    }

    private final Point p1,p2;
    double distance;

    public Circle(Point p1,Point p2){
        this.p1=p1;
        this.p2=p2;
        this.distance=p1.distanceTo(p2);
    }

    public boolean contains(){
        // 判断一个圆是否完全包含另一个圆（包括内切）
        double largerRadius = Math.max(p1.radius, p2.radius);
        double smallerRadius = Math.min(p1.radius, p2.radius);
        return distance + smallerRadius <= largerRadius;
    }

    public boolean intersects(){
        // 判断两个圆相交（包括外切）
        double radiusSum = p1.radius + p2.radius;
        double radiusDiff = Math.abs(p1.radius - p2.radius);
        return distance < radiusSum && distance >= radiusDiff;
    }

    public boolean separates(){
        // 判断两圆相离
        return distance > p1.radius + p2.radius;
    }

    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)) {
            Point p1=new Point(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
            Point p2=new Point(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
            Circle circle=new Circle(p1,p2);

            if(circle.contains()){
                System.out.printf("圆1: %s, %n圆2: %s, %n它们包含", p1, p2);
            } else if(circle.intersects()){
                System.out.printf("圆1: %s, %n圆2: %s, %n它们相交", p1, p2);
            } else if (circle.separates()) {
                System.out.printf("圆1: %s, %n圆2: %s, %n它们相离", p1, p2);
            }

        }catch (InputMismatchException e){
            System.out.println("输入数字不匹配！需要重新输入。");
        }
    }
}
