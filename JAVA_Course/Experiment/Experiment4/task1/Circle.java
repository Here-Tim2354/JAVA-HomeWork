package Experiment.Experiment4.task1;

public class Circle implements Colorable {
    private double x;
    private double y;
    private double radius;
    private String color;

    public Circle(double x, double y, double radius, String color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public void howToColor() {
        System.out.println("Circle(" + "x=" + x + ", y=" + y + ", radius=" + radius + ") - color " + color + "填充圆的内部");
    }
}
