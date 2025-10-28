package Practice.Practice4.task1;

import java.text.DecimalFormat;
import java.util.List;

public abstract class Shape {
    public static final DecimalFormat df = new DecimalFormat("#.00");

    public abstract double area();

    public abstract String getInfo();

    @Override
    public String toString() {
        return getInfo() + " 面积: " + area();
    }

    public static void printInputData(List<Shape> shapeList) {
        System.out.println("你的输入的数据为:");
        for(Shape shapes: shapeList) {
            System.out.println(shapes.toString());
        }
        System.out.println("\n");
    }
}
