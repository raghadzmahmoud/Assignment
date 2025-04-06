package main.najah.test;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.najah.code.Recipe;
import main.najah.code.RecipeException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for the Recipe class")
class RecipeTest {

    private Recipe recipe;

    @BeforeEach
    void initRecipe() {
        recipe = new Recipe();
    }

    @Test
    @DisplayName("Should set a valid amount of coffee")
    void setValidCoffeeAmount() throws RecipeException {
        recipe.setAmtCoffee("4");
        assertEquals(4, recipe.getAmtCoffee());
    }

    @Test
    @DisplayName("Should throw exception for invalid coffee input")
    void setInvalidCoffeeAmount() {
        assertAll(
            () -> assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("-2")),
            () -> assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("abc"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "2", "8"})
    @DisplayName("Should set different valid milk amounts")
    void setValidMilkAmount(String value) throws RecipeException {
        recipe.setAmtMilk(value);
        assertEquals(Integer.parseInt(value), recipe.getAmtMilk());
    }

    @Test
    @DisplayName("Should handle valid and invalid sugar amounts")
    void sugarAmountTest() {
        assertAll(
            () -> {
                recipe.setAmtSugar("3");
                assertEquals(3, recipe.getAmtSugar());
            },
            () -> assertThrows(RecipeException.class, () -> recipe.setAmtSugar("-1")),
            () -> assertThrows(RecipeException.class, () -> recipe.setAmtSugar("invalid"))
        );
    }

    @Test
    @DisplayName("Should set chocolate amount within timeout")
    @Timeout(1)
    void chocolateAmountTimeout() throws RecipeException {
        recipe.setAmtChocolate("5"); 
        assertEquals(5, recipe.getAmtChocolate());
    }

    @Test
    @DisplayName("Should set valid price and handle invalid input")
    void priceTest() {
        assertAll(
            () -> {
                recipe.setPrice("25");
                assertEquals(25, recipe.getPrice());
            },
            () -> assertThrows(RecipeException.class, () -> recipe.setPrice("-20")),
            () -> assertThrows(RecipeException.class, () -> recipe.setPrice("notanumber"))
        );
    }

    @Test
    @DisplayName("Should set and return the correct name")
    void nameTest() {
        recipe.setName("Café Latte");
        assertEquals("Café Latte", recipe.getName());
    }

    @Test
    @DisplayName("Should set multiple values and verify them all")
    void fullRecipeSetup() throws RecipeException {
        recipe.setName("Mocha");
        recipe.setAmtCoffee("3");
        recipe.setAmtMilk("2");
        recipe.setAmtSugar("1");
        recipe.setAmtChocolate("2");
        recipe.setPrice("15");

        assertAll(
            () -> assertEquals("Mocha", recipe.getName()),
            () -> assertEquals(3, recipe.getAmtCoffee()),
            () -> assertEquals(2, recipe.getAmtMilk()),
            () -> assertEquals(1, recipe.getAmtSugar()),
            () -> assertEquals(2, recipe.getAmtChocolate()),
            () -> assertEquals(15, recipe.getPrice())
        );
    }

    @Test
    @DisplayName("Should return the name in toString()")
    void toStringTest() {
        recipe.setName("Americano");
        assertEquals("Americano", recipe.toString());
    }

    @Test
    @DisplayName("Recipes with same name should be equal")
    void equalityTest() {
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();

        r1.setName("Latte");
        r2.setName("Latte");

        assertAll(
            () -> assertEquals(r1, r2),
            () -> assertEquals(r1.hashCode(), r2.hashCode())
        );
    }

    @Disabled("Intentionally failing test - fix expected value to match input")
    @Test
    @DisplayName("This test will fail on purpose")
    void failingTest() throws RecipeException {
        recipe.setAmtMilk("2");
        assertEquals(5, recipe.getAmtMilk(), "Fix this by updating expected value to 2");
    }
}
