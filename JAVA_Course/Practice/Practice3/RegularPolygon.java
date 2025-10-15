package Practice.Practice3;

import java.util.Objects;

public class RegularPolygon {
    private int numberOfSides;
    private double lengthOfSide;
    private double x;
    private double y;

    public RegularPolygon() {
        this.numberOfSides = 3;
        this.lengthOfSide = 1;
        this.x = 0;
        this.y = 0;
    }
    public RegularPolygon(int numberOfSides, double lengthOfSide) {
        this.numberOfSides = numberOfSides;
        this.lengthOfSide = lengthOfSide;
        this.x = 0;
        this.y = 0;
    }
    public RegularPolygon(int numberOfSides, double lengthOfSide, double x, double y) {
        this.numberOfSides = numberOfSides;
        this.lengthOfSide = lengthOfSide;
        this.x = x;
        this.y = y;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public double getLengthOfSide() {
        return lengthOfSide;
    }

    public void setLengthOfSide(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getArea() {
        return (numberOfSides * lengthOfSide * lengthOfSide) / (4 * Math.tan(Math.PI / numberOfSides));
    }
    public double getOffset() {
        return Math.hypot(x,y);
    }

    @Override
    public String toString() {
        return String.format("边数%d, 边长%.2f, 坐标(%.2f, %.2f)",
                numberOfSides, lengthOfSide, x, y);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RegularPolygon that = (RegularPolygon) obj;
        return numberOfSides == that.numberOfSides &&
                Double.compare(that.lengthOfSide, lengthOfSide) == 0 &&
                Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(numberOfSides, lengthOfSide, x, y);
    }
}
