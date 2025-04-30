package calculator;

public class FunctionalCalculator {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> {
            if (b == 0) throw new ArithmeticException("Cannot divide by zero");
            return a / b;
        };

        double x = 10, y = 2;

        System.out.println("Functional Calculator:");
        System.out.println("Add: " + add.calculate(x, y));
        System.out.println("Subtract: " + subtract.calculate(x, y));
        System.out.println("Multiply: " + multiply.calculate(x, y));
        System.out.println("Divide: " + divide.calculate(x, y));
    }
}
