package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.najah.code.Calculator;

@DisplayName("Testing Calculator Methods")
@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @Order(1)
    @DisplayName("Addition: Valid Inputs")
    void testAdditionValid() {

        assertAll(
            () -> assertEquals(9, calculator.add(4, 5)),
            () -> assertEquals(0, calculator.add()),
            () -> assertEquals(-10, calculator.add(-5, -5))
        );
    }

    @Test
    @Order(2)
    @DisplayName("Addition: Invalid Input (Edge Cases)")
    void testAdditionInvalid() {

        assertAll(
            () -> assertEquals(0, calculator.add(-2, 2)), // Should be zero
            () -> assertEquals(10, calculator.add(10)), // Single value
            () -> assertEquals(-100, calculator.add(-100)) // Single negative value
        );
    }

    @Test
    @Order(3)
    @DisplayName("Division: Valid Inputs")
    void testDivisionValid() {

        assertAll(
            () -> assertEquals(4, calculator.divide(20, 5)),
            () -> assertEquals(-4, calculator.divide(20, -5)),
            () -> assertEquals(1, calculator.divide(5, 5))
        );
    }

    @Test
    @Order(4)
    @DisplayName("Division: Invalid (Division by Zero)")
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }

    @ParameterizedTest
    @MethodSource("provideFactorialValues")
    @Order(5)
    @DisplayName("Factorial: Multiple Cases")
    void testFactorial(int input, int expectedOutput) {
        assertEquals(expectedOutput, calculator.factorial(input));
    }

    static Stream<Arguments> provideFactorialValues() {
        return Stream.of(
            Arguments.of(0, 1),
            Arguments.of(1, 1),
            Arguments.of(4, 24),
            Arguments.of(6, 720)
        );
    }

    @Test
    @Order(6)
    @DisplayName("Factorial: Invalid (Negative Number)")
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-3));
    }

    @Test
    @Order(7)
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    @DisplayName("Performance: Large Addition Calculation")
    void testAdditionPerformance() {
        int[] largeNumbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largeNumbers[i] = i + 1;
        }
        assertEquals(500500, calculator.add(largeNumbers));
    }

    @Test
    @Order(8)
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    @DisplayName("Performance: Factorial Calculation")
    void testFactorialPerformance() {
        assertDoesNotThrow(() -> calculator.factorial(20));
    }
}
