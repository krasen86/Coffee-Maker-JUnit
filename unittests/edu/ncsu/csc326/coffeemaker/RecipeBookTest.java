package edu.ncsu.csc326.coffeemaker;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class RecipeBookTest {

    private RecipeBook recipeBook;
    private Recipe recipeTest1;
    private Recipe recipeTest2;

    @BeforeEach
    void setUp() throws RecipeException {
        recipeBook = new RecipeBook();
        recipeTest1 = new Recipe();
        recipeTest1.setName("Coffee");
        recipeTest1.setAmtChocolate("0");
        recipeTest1.setAmtCoffee("3");
        recipeTest1.setAmtMilk("1");
        recipeTest1.setAmtSugar("1");
        recipeTest1.setPrice("50");

        recipeTest2 = new Recipe();
        recipeTest2.setName("Tea");
        recipeTest2.setAmtChocolate("0");
        recipeTest2.setAmtCoffee("3");
        recipeTest2.setAmtMilk("1");
        recipeTest2.setAmtSugar("1");
        recipeTest2.setPrice("50");
    }

    @Test
    void testAddRecipe(){
        Recipe[] recipes = recipeBook.getRecipes();
        Assertions.assertTrue(recipeBook.addRecipe(recipeTest1));
        Recipe recipeTest = recipes[0];
        Assertions.assertEquals(recipeTest1, recipeTest);
        Assertions.assertFalse(recipeBook.addRecipe(recipeTest1));
    }

    @Test
    void testAddRecipeAddingTheSameRecipe(){
        Recipe[] recipes = recipeBook.getRecipes();
        recipeBook.addRecipe(recipeTest1);
        Assertions.assertFalse(recipeBook.addRecipe(recipeTest1));
    }

    @Test
    void testGetRecipeBooks(){
        Recipe [] recipes = new Recipe[4];
        Assertions.assertArrayEquals( recipes, recipeBook.getRecipes() );
    }

    @Test
    void testDeleteRecipe(){
        recipeBook.addRecipe(recipeTest1);
        recipeBook.addRecipe(recipeTest2);
        Recipe[] recipes = recipeBook.getRecipes();
        recipeBook.deleteRecipe(0);
        Recipe recipeTest = recipes[0];
        Assertions.assertNotSame(recipeTest1, recipeTest);
    }

    @Test
    void testDeleteRecipeThatIsNull(){
        Assertions.assertNull(recipeBook.deleteRecipe(3));
    }

    @Test
    void testEditRecipe(){
        recipeBook.addRecipe(recipeTest1);
        recipeBook.editRecipe(0, recipeTest2);
        recipeTest2.setName("Coffee");
        Recipe[] recipes = recipeBook.getRecipes();
        Assertions.assertEquals(recipes[0], recipeTest2);
    }

    @Test
    void testEditRecipeAtNullPosition() {
        Assertions.assertNull(recipeBook.editRecipe(0, recipeTest2));
    }
}
