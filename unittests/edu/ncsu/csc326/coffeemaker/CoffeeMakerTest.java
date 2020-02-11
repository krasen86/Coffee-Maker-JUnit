package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeMakerTest {

    private RecipeBook recipeBook;
    private Recipe recipeTest1;
    private Recipe recipeTest2;
    private CoffeeMaker coffeeMaker;
    private Inventory inventory;

    @BeforeEach
    void setUp() throws RecipeException {
        inventory = new Inventory();
        coffeeMaker = new CoffeeMaker();
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
     * @Test Case ID:
     */
    @Test
    void testGetRecipes(){
        coffeeMaker.addRecipe(recipeTest1);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = recipeTest1;
        Assertions.assertArrayEquals(recipes ,coffeeMaker.getRecipes());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testDeleteRecipe(){
        coffeeMaker.addRecipe(recipeTest1);
        coffeeMaker.addRecipe(recipeTest2);
        Recipe[] recipes = coffeeMaker.getRecipes();
        coffeeMaker.deleteRecipe(0);
        Recipe recipeTest = recipes[0];
        Assertions.assertNotSame(recipeTest1, recipeTest);
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testDeleteRecipeThatIsNull(){
        Assertions.assertNull(coffeeMaker.deleteRecipe(3));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testAddRecipe(){
        Recipe[] recipes = coffeeMaker.getRecipes();
        Assertions.assertTrue(coffeeMaker.addRecipe(recipeTest1));
        Recipe recipeTest = recipes[0];
        Assertions.assertEquals(recipeTest1, recipeTest);
        Assertions.assertFalse(coffeeMaker.addRecipe(recipeTest1));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testAddRecipeAddingTheSameRecipe(){
        Recipe[] recipes = coffeeMaker.getRecipes();
        coffeeMaker.addRecipe(recipeTest1);
        Assertions.assertFalse(coffeeMaker.addRecipe(recipeTest1));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testEditRecipe() throws RecipeException {

        coffeeMaker.addRecipe(recipeTest1);
        Recipe testRecipe = new Recipe();
        testRecipe.setName("Tea");
        testRecipe.setAmtChocolate("0");
        testRecipe.setAmtCoffee("3");
        testRecipe.setAmtMilk("1");
        testRecipe.setAmtSugar("1");
        testRecipe.setPrice("50");
        coffeeMaker.editRecipe(0, recipeTest2);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = testRecipe;
        Assertions.assertArrayEquals(recipes, coffeeMaker.getRecipes());
        Assertions.assertSame(testRecipe, coffeeMaker.getRecipes()[0]);
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testEditRecipeAtNullPosition() {
        Assertions.assertNull(coffeeMaker.editRecipe(0, recipeTest2));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testCheckInventory(){
        inventory.setMilk(10);
        inventory.setChocolate(10);
        inventory.setCoffee(10);
        inventory.setSugar(10);
        Assertions.assertEquals("Coffee: 10\n" +
                "Milk: 10\n" +
                "Sugar: 10\n" +
                "Chocolate: 10\n" , coffeeMaker.checkInventory());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testCheckInventoryNotNull(){
        Assertions.assertNotNull(coffeeMaker.checkInventory());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testAddInventory(){
        try {
            coffeeMaker.addInventory("20", "20", "20", "20");
            Assertions.assertEquals("Coffee: 20\n" +
                    "Milk: 20\n" +
                    "Sugar: 20\n" +
                    "Chocolate: 20\n", coffeeMaker.checkInventory());
        }
        catch (InventoryException e){
            e.getMessage();
        }
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testAddInventoryWithInvalidData(){
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("a","","test",null));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("","a",null,"test"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("test",null,"a",""));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory( null,"test","","a"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("-3","-6","-4","-4"));

        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("-2","10","10","10"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("10","-2","10","10"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("10","10","-2","10"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory( "10","10","10","-2"));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testAddInventoryWithZero() {
        try {
            coffeeMaker.addInventory("0", "0", "0", "0");
        }
        catch (InventoryException e){
            e.printStackTrace();
            Assertions.fail();
        }
        Assertions.assertEquals("Coffee: 15\n" +
                "Milk: 15\n" +
                "Sugar: 15\n" +
                "Chocolate: 15\n", coffeeMaker.checkInventory());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testMakeCoffee() throws RecipeException {
        recipeTest1.setPrice("50");
        coffeeMaker.addRecipe(recipeTest1);
        int testChange = coffeeMaker.makeCoffee(0,100);
        Assertions.assertEquals(50, testChange);
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testMakeCoffeeNoRecipe(){
        recipeBook.getRecipes()[0] = null;
        int testChange = coffeeMaker.makeCoffee(0,100);
        Assertions.assertEquals(100, testChange);
        recipeBook.getRecipes()[0] = new Recipe();
        testChange = coffeeMaker.makeCoffee(0,100);
        Assertions.assertEquals(100, testChange);
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testMakeCoffeeInvalidRecipeInput(){
        int testChange = coffeeMaker.makeCoffee(coffeeMaker.getRecipes().length +1,100);
        Assertions.assertEquals(100, testChange);
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testMakeCoffeeInvalidPriceInput() throws RecipeException {
        recipeTest1.setPrice("50");
        coffeeMaker.addRecipe(recipeTest1);
        int testChange = coffeeMaker.makeCoffee(0,-3);
        Assertions.assertEquals(0, testChange);
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testMakeCoffeeInvalidSmallerPriceInput() throws RecipeException{
        recipeTest1.setPrice("50");
        coffeeMaker.addRecipe(recipeTest1);
        int testChange = coffeeMaker.makeCoffee(0,10);
        Assertions.assertEquals(10, testChange);

    }
    /**
     * @Test Case ID:
     */
    @Test
    void testMakeCoffeeNoInventory() throws RecipeException{
        recipeTest1.setPrice("50");
        coffeeMaker.addRecipe(recipeTest1);
        inventory.setSugar(0);
        inventory.setCoffee(0);
        inventory.setChocolate(0);
        inventory.setMilk(0);
        int testChange = coffeeMaker.makeCoffee(0,100);
        Assertions.assertEquals(100, testChange);

    }
}
