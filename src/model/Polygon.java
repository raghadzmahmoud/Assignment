package model;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends ClosedShape {
    protected List<Point> pointList = new ArrayList<>();

    public void addPoint(Point p) {
        pointList.add(p);
    }

    public Point getPoint(int index) {
        return pointList.get(index);
    }

    public boolean isRectangle() {
        return false;
    }

    public boolean isSquare() {
        return false;
    }

    public boolean isTriangle() {
        return pointList.size() == 3;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Polygon.");
    }

    @Override
    public float getArea() {
        return 0; // Will be overridden in specific shapes
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
        for (Point p : pointList) {
            p.moveBy(x, y);
        }
    }
}
