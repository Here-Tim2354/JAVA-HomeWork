package Practice.Practice4.task1;

import java.util.List;

public class SumOfAreas {
    public static double sumAreas(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.area();
        }
        return totalArea;
    }
}
