package model;

public class Ellipse extends ClosedShape {
    private Point focus1;
    private Point focus2;
    private int major;
    private int minor;

    public Ellipse(Point focus1, Point focus2, int major, int minor) {
        this.focus1 = focus1;
        this.focus2 = focus2;
        this.major = major;
        this.minor = minor;
    }

    public static Ellipse createEllipse(Point focus1, Point focus2, int major, int minor) {
        return new Ellipse(focus1, focus2, major, minor);
    }

    public void update(Point focus1, Point focus2, int major, int minor) {
        this.focus1 = focus1;
        this.focus2 = focus2;
        this.major = major;
        this.minor = minor;
    }

    // Getters
    public Point getFocus1() {
        return focus1;
    }

    public Point getFocus2() {
        return focus2;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    // Setters
    public void setFocus1(Point focus1) {
        this.focus1 = focus1;
    }

    public void setFocus2(Point focus2) {
        this.focus2 = focus2;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    @Override
    public void draw() {
        System.out.println("Drawing an Ellipse.");
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * major * minor);
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
        focus1.moveBy(x, y);
        focus2.moveBy(x, y);
    }
}
