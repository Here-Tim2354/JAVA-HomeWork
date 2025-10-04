import java.util.Scanner;
import java.lang.Math;

public class CylinderVolume {
    double radius;
    double height;
    final double Pi=Math.PI;

    public CylinderVolume(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getVolume() {
        return Math.pow(radius, 2) *Pi* height;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        CylinderVolume cylinder=new CylinderVolume(s.nextDouble(),s.nextDouble());
        String result=String.format("%.2f",cylinder.getVolume());
        System.out.println(result);
    }
}