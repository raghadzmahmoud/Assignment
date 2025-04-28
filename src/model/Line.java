package model;

public class Line extends ClosedShape {
    private Point begin;
    private Point end;

    public Line(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public static Line intWithValues(Point begin, Point end) {
        return new Line(begin, end);
    }

    public float getLength() {
        return calculateLength(begin, end);
    }

    public static float calculateLength(Point p1, Point p2) {
        return (float) Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Line.");
    }

    @Override
    public float getArea() {
        return 0; // Line has no area
    }

    @Override
    public void moveUp(int m) {
        moveBy(0, m);
    }

    @Override
    public void moveDown(int m) {
        moveBy(0, -m);
    }

    @Override
    public void moveLeft(int m) {
        moveBy(-m, 0);
    }

    @Override
    public void moveRight(int m) {
        moveBy(m, 0);
    }

    @Override
    public void moveBy(int x, int y) {
        begin.moveBy(x, y);
        end.moveBy(x, y);
    }
}
