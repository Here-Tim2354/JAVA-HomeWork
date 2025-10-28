package Practice.Practice4.task1;

public class Trapezoid extends Shape{
    private final double topWidth;
    private final double bottomWidth;
    private final double height;
    
    public Trapezoid(double topWidth, double bottomWidth, double height) {
        this.topWidth = topWidth;
        this.bottomWidth = bottomWidth;
        this.height = height;
    }

    public double getTopWidth() {
        return topWidth;
    }

    public double getBottomWidth() {
        return bottomWidth;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String getInfo() {
        return "梯形 "+"上底: "+ topWidth +", 下底: "+ bottomWidth +", 高: "+ height;
    }


    @Override
    public double area() {
        return  Double.parseDouble(Shape.df.format((topWidth + bottomWidth) * height / 2));
    }
    
    
}
