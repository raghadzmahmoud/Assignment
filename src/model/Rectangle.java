package model;

public class Rectangle extends Polygon {
    private Point upperCorner;
    private int width;
    private int height;

    public Rectangle(Point upperCorner, int width, int height) {
        this.setUpperCorner(upperCorner);
        this.width = width;
        this.height = height;
    }

    public static Rectangle createRectangle(Point upperCorner, int width, int height) {
        return new Rectangle(upperCorner, width, height);
    }

    public void update(Point upperCorner, int width, int height) {
        this.setUpperCorner(upperCorner);
        this.width = width;
        this.height = height;
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    @Override
    public float getArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle.");
    }

	public Point getUpperCorner() {
		return upperCorner;
	}

	public void setUpperCorner(Point upperCorner) {
		this.upperCorner = upperCorner;
	}
}
