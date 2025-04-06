package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import main.najah.code.Product;

@DisplayName("Testing Product Methods")
public class ProductTest {
    private Product product;
    private static int testCounter = 0;

    @BeforeAll
    static void initSuite() {
        System.out.println("Starting Product Test");
    }

    @AfterAll
    static void completeSuite() {
        System.out.println("Completed Product Test");
    }

    @BeforeEach
    void setup() {
        testCounter++;
        System.out.println("\nSetting up test #" + testCounter);
        product = new Product("Test Product", 100.0);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test #" + testCounter + " completed");
    }

    @Test
    @DisplayName("Creation: Valid Properties")
    void testCreationValid() {

        assertAll(
            () -> assertEquals("Test Product", product.getName()),
            () -> assertEquals(100.0, product.getPrice()),
            () -> assertEquals(0.0, product.getDiscount())
        );
    }

    @Test
    @DisplayName("Creation: Invalid Price")
    void testCreationInvalid() {

        assertThrows(IllegalArgumentException.class,() -> new Product("Invalid", -50.0));
    }

    @Test
    @DisplayName("Discount: Valid Applications")
    void testValidDiscounts() {

        assertAll(
            () -> assertDoesNotThrow(() -> product.applyDiscount(0.0)),
            () -> assertDoesNotThrow(() -> product.applyDiscount(50.0)),
            () -> assertDoesNotThrow(() -> product.applyDiscount(25.0))
        );
    }

    @Test
    @DisplayName("Discount: Invalid Applications")
    void testInvalidDiscounts() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class,() -> product.applyDiscount(-1.0)),
            () -> assertThrows(IllegalArgumentException.class,() -> product.applyDiscount(51))
        );
    }

    @ParameterizedTest
    @MethodSource("providePriceValues")
    @DisplayName("Price Calculation: Multiple Cases")
    void testFinalPrice(double discount, double expected) {
        product.applyDiscount(discount);
        assertEquals(expected, product.getFinalPrice());
    }

    static Stream<Arguments> providePriceValues() {
        return Stream.of(
            Arguments.of(0.0, 100.0),
            Arguments.of(10.0, 90.0),
            Arguments.of(50.0, 50.0),
            Arguments.of(25.5, 74.5)
        );
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @DisplayName("Performance: Rapid Discount Updates")
    void testDiscountPerformance() {
        for(int i = 0; i < 1000000; i++) {
            product.applyDiscount(i % 50);
        }
    }

    @Test
    @DisplayName("State: Discount Persistence")
    void testDiscountPersistence() {
        product.applyDiscount(10.0);
        assertEquals(10.0, product.getDiscount());
        
        product.applyDiscount(20.0);
        assertEquals(20.0, product.getDiscount());
    }
}