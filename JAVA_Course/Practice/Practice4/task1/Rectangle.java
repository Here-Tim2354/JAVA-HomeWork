package Practice.Practice4.task1;

public class Rectangle extends Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String getInfo() {
        return "矩形 "+"长: "+ length +", 宽: "+ width;
    }

    @Override
    public double area() {
        return Double.parseDouble(Shape.df.format(length*width));
    }


}
