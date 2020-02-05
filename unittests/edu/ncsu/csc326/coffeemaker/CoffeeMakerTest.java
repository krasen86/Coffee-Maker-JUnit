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

    @Test
    void testGetRecipes(){
        coffeeMaker.addRecipe(recipeTest1);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = recipeTest1;
        Assertions.assertArrayEquals(recipes ,coffeeMaker.getRecipes());
    }

    @Test
    void testDeleteRecipe(){
        coffeeMaker.addRecipe(recipeTest1);
        coffeeMaker.addRecipe(recipeTest2);
        Recipe[] recipes = coffeeMaker.getRecipes();
        coffeeMaker.deleteRecipe(0);
        Recipe recipeTest = recipes[0];
        Assertions.assertNotSame(recipeTest1, recipeTest);
    }

    @Test
    void testDeleteRecipeThatIsNull(){
        Assertions.assertNull(coffeeMaker.deleteRecipe(3));
    }

    @Test
    void testAddRecipe(){
        Recipe[] recipes = coffeeMaker.getRecipes();
        Assertions.assertTrue(coffeeMaker.addRecipe(recipeTest1));
        Recipe recipeTest = recipes[0];
        Assertions.assertEquals(recipeTest1, recipeTest);
        Assertions.assertFalse(coffeeMaker.addRecipe(recipeTest1));
    }

    @Test
    void testAddRecipeAddingTheSameRecipe(){
        Recipe[] recipes = coffeeMaker.getRecipes();
        coffeeMaker.addRecipe(recipeTest1);
        Assertions.assertFalse(coffeeMaker.addRecipe(recipeTest1));
    }

    @Test
    void testEditRecipe(){
        coffeeMaker.addRecipe(recipeTest1);
        coffeeMaker.editRecipe(0, recipeTest2);
        recipeTest2.setName("Coffee");
        Recipe[] recipes = coffeeMaker.getRecipes();
        Assertions.assertEquals(recipes[0], recipeTest2);
    }

    @Test
    void testEditRecipeAtNullPosition() {
        Assertions.assertNull(coffeeMaker.editRecipe(0, recipeTest2));
    }

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

    @Test
    void testCheckInventoryNotNull(){
        Assertions.assertNotNull(coffeeMaker.checkInventory());
    }

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

    @Test
    void testAddInventoryWithInvalidData(){
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("a","","test",null));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("","a",null,"test"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("test",null,"a",""));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory( null,"test","","a"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("-3","-6","-4","-4"));

    }
}
