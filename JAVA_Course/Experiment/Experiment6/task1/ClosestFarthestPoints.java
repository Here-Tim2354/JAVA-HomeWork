package Experiment.Experiment6.task1;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class ClosestFarthestPoints {
    private record Point(double x, double y) {
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    };
    public record pairPoint(Point a, Point b, double distance) {
        @Override
        public String toString() {
            return "点A: " + a.toString() + ", 点B: " + b.toString() + ", 距离为: " + distance;
        }
    };
    public enum SWITCHER {
        CLOSEST,
        FARTHEST
    };

    private HashSet<Point> points;

    public ClosestFarthestPoints() {
        points = new HashSet<>();
    }

    public void addPoint(double x, double y) {
            points.add(new Point(x, y));
    }

    public pairPoint pairPointResult(SWITCHER mode){
        List<Point> pointList=new ArrayList<>(points);
        if(pointList.size()<2){
            throw new IllegalArgumentException("点的数量不足以计算最近点或最远点");
        }

        double bestDistance = (mode == SWITCHER.CLOSEST) ? Double.MAX_VALUE : -1.0;

        Point bestA = null;
        Point bestB = null;

        for (int i = 0; i < pointList.size() - 1; i++) {
            for (int j = i + 1; j < pointList.size(); j++) {
                Point pointA = pointList.get(i);
                Point pointB = pointList.get(j);
                double distance = Math.sqrt(Math.pow(pointA.x - pointB.x, 2) + Math.pow(pointA.y - pointB.y, 2));

                if ((mode == SWITCHER.CLOSEST && distance < bestDistance) ||
                    (mode == SWITCHER.FARTHEST && distance > bestDistance)) {
                    bestDistance = distance;
                    bestA = pointA;
                    bestB = pointB;
                }
            }
        }

        return new pairPoint(bestA, bestB, bestDistance);
    }

    public pairPoint getClosestPoints(){
        return pairPointResult(SWITCHER.CLOSEST);
    }

    public pairPoint getFarthestPoints(){
        return pairPointResult(SWITCHER.FARTHEST);
    }

    public int getNumberOfPoints(){
        return points.size();
    }

    public void printPoints(){
        for(Point p:points){
            System.out.println("Point: (" + p.x + ", " + p.y + ")");
        }
    }

}
