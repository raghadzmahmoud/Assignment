package model;

public class Square extends Rectangle {

    public Square(Point upperCorner, int side) {
        super(upperCorner, side, side);
    }

    public static Square createSquare(Point upperCorner, int side) {
        return new Square(upperCorner, side);
    }

    public void update(Point upperCorner, int side) {
        super.update(upperCorner, side, side);
    }

    public int getSide() {
        return getWidth();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square.");
    }
}
