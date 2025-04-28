package model;

public class Circle extends Ellipse {

    public Circle(Point center, int radius) {
        super(center, center, radius, radius);
    }

    public static Circle createCircle(Point center, int radius) {
        return new Circle(center, radius);
    }

    public void update(Point center, int radius) {
        super.update(center, center, radius, radius);
    }

    public Point getCenter() {
        return super.getFocus1();
    }

    public int getRadius() {
        return super.getMajor();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}
