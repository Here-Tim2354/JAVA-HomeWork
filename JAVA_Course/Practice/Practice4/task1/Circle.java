package Practice.Practice4.task1;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String getInfo() {
        return "圆形 "+ "半径: " + radius;
    }

    @Override
    public double area() {
        return Double.parseDouble(Shape.df.format(Math.PI * radius * radius));
    }
}
