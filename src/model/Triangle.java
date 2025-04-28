package model;

public class Triangle extends Polygon {

    public Triangle(Point p1, Point p2, Point p3) {
        addPoint(p1);
        addPoint(p2);
        addPoint(p3);
    }

    public static Triangle createTriangle(Point p1, Point p2, Point p3) {
        return new Triangle(p1, p2, p3);
    }

    public void update(Point p1, Point p2, Point p3) {
        pointList.clear();
        addPoint(p1);
        addPoint(p2);
        addPoint(p3);
    }

    @Override
    public float getArea() {
        Point a = getPoint(0);
        Point b = getPoint(1);
        Point c = getPoint(2);

        return Math.abs((a.getX() * (b.getY() - c.getY()) +
                         b.getX() * (c.getY() - a.getY()) +
                         c.getX() * (a.getY() - b.getY())) / 2.0f);
    }
}
