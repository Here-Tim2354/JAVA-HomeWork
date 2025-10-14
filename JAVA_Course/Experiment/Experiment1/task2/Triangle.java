package Experiment.Experiment1.task2;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * 一个可独立运行的 Triangle 类，用于计算并输出三角形的面积。
 * 将所有逻辑封装在单个文件中。
 */
public class Triangle {
    private record Point(double x, double y) {
        // 计算到另一个点的距离
        public double distanceTo(Point other) {
            return Math.hypot(this.x - other.x, this.y - other.y);
        }
    }

    private final Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    /**
     * 使用海伦公式计算三角形的面积。
     * @return 三角形的面积
     */
    public double getArea() {
        double s1 = p1.distanceTo(p2);
        double s2 = p2.distanceTo(p3);
        double s3 = p3.distanceTo(p1);

        double s = (s1 + s2 + s3) / 2.0;

        return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }

    public static void main(String[] args) {
        // 使用 try-with-resources 确保 Scanner 自动关闭
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
            System.out.println("请输入三角形三个顶点的坐标 (格式: x1 y1 x2 y2 x3 y3):");

            // 读取坐标并创建 Point 实例
            Point p1 = new Point(scanner.nextDouble(), scanner.nextDouble());
            Point p2 = new Point(scanner.nextDouble(), scanner.nextDouble());
            Point p3 = new Point(scanner.nextDouble(), scanner.nextDouble());

            // 创建 Triangle 实例并计算面积
            Triangle triangle = new Triangle(p1, p2, p3);
            double area = triangle.getArea();

            // 格式化输出结果
            System.out.printf(Locale.US, "三角形的面积是: %.2f%n", area);

        } catch (InputMismatchException e) {
            System.err.println("输入错误：请输入6个有效的数字。");
        }
    }
}
