package calculator;

public class Main {
    public static void main(String[] args) {
        OOPCalculator oop = new OOPCalculator();
        double a = 18, b = 5;

        System.out.println("OOP Calculator:");
        System.out.println("Add: " + oop.add(a, b));
        System.out.println("Subtract: " + oop.subtract(a, b));
        System.out.println("Multiply: " + oop.multiply(a, b));
        System.out.println("Divide: " + oop.divide(a, b));
        System.out.println("Mod: " + oop.mod(a, b));

        System.out.println("\nFunctional Calculator:");
        Calculator add = (x, y) -> x + y;
        Calculator subtract = (x, y) -> x - y;
        Calculator multiply = (x, y) -> x * y;
        Calculator divide = (x, y) -> {
            if (y == 0) throw new ArithmeticException("Cannot divide by zero");
            return x / y;
        };

        System.out.println("Add: " + add.calculate(a, b));
        System.out.println("Subtract: " + subtract.calculate(a, b));
        System.out.println("Multiply: " + multiply.calculate(a, b));
        System.out.println("Divide: " + divide.calculate(a, b));
    }
}
