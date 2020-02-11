package edu.ncsu.csc326.coffeemaker;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
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
    /**
     * @Test Case ID: 35
     */
    @Test
    void testAddRecipe(){
        Recipe[] recipes = recipeBook.getRecipes();
        Assertions.assertTrue(recipeBook.addRecipe(recipeTest1));
        Recipe recipeTest = recipes[0];
        Assertions.assertEquals(recipeTest1, recipeTest);
        Assertions.assertFalse(recipeBook.addRecipe(recipeTest1));
    }
    /**
     * @Test Case ID: 36
     */
    @Test
    void testAddRecipeAddingTheSameRecipe(){
        Recipe[] recipes = recipeBook.getRecipes();
        recipeBook.addRecipe(recipeTest1);
        Assertions.assertFalse(recipeBook.addRecipe(recipeTest1));
    }
    /**
     * @Test Case ID: 37
     */
    @Test
    void testGetRecipeBooks(){
        Recipe [] recipes = new Recipe[4];
        recipes[0] = recipeTest1;
        recipeBook.addRecipe(recipeTest1);
        Assertions.assertArrayEquals( recipes, recipeBook.getRecipes() );
    }
    /**
     * @Test Case ID: 38
     */
    @Test
    void testDeleteRecipe(){
        recipeBook.addRecipe(recipeTest1);
        recipeBook.deleteRecipe(0);
        Assertions.assertNotSame(recipeTest1, recipeBook.getRecipes()[0]);
    }
    /**
     * @Test Case ID: 39
     */
    @Test
    void testDeleteRecipeThatIsEmpty(){
        Assertions.assertNull(recipeBook.deleteRecipe(3));
    }
    /**
     * @Test Case ID: 42
     */
    @Test
    void deleteInvalidRecipe() {
        Assertions.assertNull(recipeBook.deleteRecipe(recipeBook.getRecipes().length + 10));
    }
    /**
     * @Test Case ID: 40
     */
    @Test
    void testEditRecipe() throws RecipeException {
        recipeBook.addRecipe(recipeTest1);
        Recipe testRecipe = new Recipe();
        testRecipe.setName("Tea");
        testRecipe.setAmtChocolate("0");
        testRecipe.setAmtCoffee("3");
        testRecipe.setAmtMilk("1");
        testRecipe.setAmtSugar("1");
        testRecipe.setPrice("50");
        recipeBook.editRecipe(0, recipeTest2);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = testRecipe;
        Assertions.assertArrayEquals(recipes, recipeBook.getRecipes());
        Assertions.assertSame(testRecipe, recipeBook.getRecipes()[0]);
    }
    /**
     * @Test Case ID: 41
     */
    @Test
    void testEditRecipeAtNullPosition() {

        Assertions.assertNull(recipeBook.editRecipe(0, recipeTest2));
    }
    /**
     * @Test Case ID: 43
     */
    @Test
    void testEditRecipeWithNullRecipe() {
        recipeBook.addRecipe(recipeTest1);
        Assertions.assertNull(recipeBook.editRecipe(0, null));
    }
}
