package edu.ncsu.csc326.coffeemaker;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class RecipeBookTest {

    private RecipeBook recipeBook;
    private Recipe r1;

    @BeforeEach
    public void setUp() throws RecipeException {
        recipeBook = new RecipeBook();
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");
    }

    @Test
    public void testAddRecipe(){
        Assertions.assertTrue(recipeBook.addRecipe(r1));

    }
}
