package model;

public class Main {
    public static void main(String[] args) {
        // Create a circle
        Circle circle = Circle.createCircle(new Point(5, 5), 10);
        System.out.println("Circle Area: " + circle.getArea());
        circle.draw();
        circle.moveRight(5);
        System.out.println("Circle moved to: (" + circle.getCenter().getX() + ", " + circle.getCenter().getY() + ")");

        System.out.println("---------------------------");

        // Create a rectangle
        Rectangle rectangle = Rectangle.createRectangle(new Point(0, 0), 20, 10);
        System.out.println("Rectangle Area: " + rectangle.getArea());
        rectangle.draw();
        rectangle.moveDown(10);
        System.out.println("Rectangle moved to: (" + rectangle.getUpperCorner().getX() + ", " + rectangle.getUpperCorner().getY() + ")");

        System.out.println("---------------------------");

        // Create a square
        Square square = Square.createSquare(new Point(1, 1), 15);
        System.out.println("Square Area: " + square.getArea());
        square.draw();
        square.moveUp(10);
        System.out.println("Square moved to: (" + square.getUpperCorner().getX() + ", " + square.getUpperCorner().getY() + ")");

        System.out.println("---------------------------");

        // Create an ellipse
        Ellipse ellipse = Ellipse.createEllipse(new Point(2, 2), new Point(4, 4), 8, 5);
        System.out.println("Ellipse Area: " + ellipse.getArea());
        ellipse.draw();
        ellipse.moveBy(3, 3);
        System.out.println("Ellipse moved to: Focus1 (" + ellipse.getFocus1().getX() + ", " + ellipse.getFocus1().getY() + 
            "), Focus2 (" + ellipse.getFocus2().getX() + ", " + ellipse.getFocus2().getY() + ")");

        System.out.println("---------------------------");

        // Create a triangle
        Triangle triangle = Triangle.createTriangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        System.out.println("Triangle Area: " + triangle.getArea());
        triangle.draw();
        triangle.moveLeft(5);
        System.out.println("Triangle moved: Point1 (" + triangle.getPoint(0).getX() + ", " + triangle.getPoint(0).getY() + ")");
    }
}
