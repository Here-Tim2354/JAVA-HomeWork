package Practice.Practice2.task3;

import java.util.Scanner;

public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public boolean getDiscriminant(){
        return !(b * b - 4 * a * c < 0);
    }
    public double getRoot1(){
        return (-b+Math.sqrt(b*b-4*a*c))/2*a;
    }
    public double getRoot2(){
        return (-b-Math.sqrt(b*b-4*a*c))/2*a;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double c=sc.nextDouble();
    }
}
