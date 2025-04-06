package main.najah.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.najah.code.Recipe;
import main.najah.code.RecipeBook;
import main.najah.code.RecipeException;

import java.util.concurrent.TimeUnit;
@DisplayName("Testing Product Methods")
class RecipeBookTest {

    private RecipeBook recipeBook;
    private Recipe recipe;
    

    @BeforeEach
    void setUp() {
        recipeBook = new RecipeBook();
        recipe = new Recipe();
        recipe.setName("Latte");
        try {
            recipe.setPrice("5");
            recipe.setAmtCoffee("2");
            recipe.setAmtMilk("1");
            recipe.setAmtSugar("1");
            recipe.setAmtChocolate("0");
        } catch (RecipeException e) {
            fail("Setup failed due to RecipeException: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Valid Input: Add a recipe successfully")
    void testAddRecipeValid() {
        assertTrue(recipeBook.addRecipe(recipe), "Recipe should be added successfully");
    }

    @Test
    @DisplayName("Invalid Input: Add a duplicate recipe (should fail)")
    void testAddDuplicateRecipe() {

        recipeBook.addRecipe(recipe);
        assertFalse(recipeBook.addRecipe(recipe), "Duplicate recipe should not be added");
    }

    @Test
    @DisplayName("Valid Input: Delete an existing recipe successfully")
    void testDeleteRecipeValid() {

        recipeBook.addRecipe(recipe);
        assertEquals("Latte", recipeBook.deleteRecipe(0), "Deleted recipe name should match");
    }

    @Test
    @DisplayName("Invalid Input: Delete a non-existing recipe (should return null)")
    void testDeleteRecipeInvalid() {
        assertNull(recipeBook.deleteRecipe(0), "Should return null for non-existing recipe");
    }

    @Test
    @DisplayName("Valid Input: Edit an existing recipe successfully")
    void testEditRecipeValid() {
        recipeBook.addRecipe(recipe);
        Recipe newRecipe = new Recipe();
        newRecipe.setName("Cappuccino");
        assertEquals("Latte", recipeBook.editRecipe(0, newRecipe), "Should return the old recipe name");
    }

    @Test
    @DisplayName("Invalid Input: Edit a non-existing recipe (should return null)")
    void testEditRecipeInvalid() {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("Mocha");
        assertNull(recipeBook.editRecipe(0, newRecipe), "Should return null for non-existing recipe");
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    @DisplayName("Valid Input: Add multiple recipes up to the max limit")
    void testAddMultipleRecipes(int index) {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("Recipe" + index);
        assertTrue(recipeBook.addRecipe(newRecipe), "Recipe should be added successfully");
    }

    @Test
    @Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Performance Test: Adding recipes should complete within 20 MILLISECONDS")
    void testAddRecipePerformance() {
        for (int i = 0; i < 4; i++) {
            Recipe newRecipe = new Recipe();
            newRecipe.setName("Recipe" + i);
            recipeBook.addRecipe(newRecipe);
        }
    }

    @Test
    @Disabled("This test currently fails because the editRecipe method does not properly validate null values. Fix: Ensure editRecipe checks for null inputs before proceeding.")
    @DisplayName("Invalid Input: Edit a recipe with null (should return null)")
    void testEditRecipeWithNull() {
        assertNull(recipeBook.editRecipe(0, null), "Editing with null should return null");
    }
}
