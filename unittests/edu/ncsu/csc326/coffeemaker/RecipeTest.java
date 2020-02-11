package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RecipeTest  {

    private Recipe recipe;
    private Recipe recipe2;
    private Assertions a;

    @BeforeEach
    void setUp() throws RecipeException {
        recipe = new Recipe();
        recipe.setAmtChocolate("5");
        recipe.setAmtCoffee("10");
        recipe.setAmtMilk("8");
        recipe.setAmtSugar("7");
        recipe.setName("name");
        recipe.setPrice("50");

        recipe2 = new Recipe();
        recipe2.setAmtChocolate("5");
        recipe2.setAmtCoffee("10");
        recipe2.setAmtMilk("8");
        recipe2.setAmtSugar("7");
        recipe2.setName("name");
        recipe2.setPrice("50");
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testGetAmtChocolatePositiveInt(){
        a.assertEquals(5,recipe.getAmtChocolate());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtChocolate() throws RecipeException {
        recipe.setAmtChocolate("12");
        a.assertEquals(12,recipe.getAmtChocolate());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtChocolateNegativeNumber(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtChocolate(-1+""));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtChocolateInvalid(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("Blah"));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtChocolateNoInput(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtChocolate(""));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testGetAmtCoffee(){
        a.assertEquals(10,recipe.getAmtCoffee());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtCoffee() throws RecipeException {
        recipe.setAmtCoffee("17");
        a.assertEquals(17,recipe.getAmtCoffee());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtCoffeeNegativeNumber(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtCoffee(-1+""));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtCoffeeInvalid(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("Blah"));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtCoffeeEmptyInput(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtCoffee(""));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testGetAmtMilk(){
        a.assertEquals(8,recipe.getAmtMilk());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtMilk() throws RecipeException {
        recipe.setAmtMilk("9");
        a.assertEquals(9,recipe.getAmtMilk());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtMilkNegativeNumber(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtMilk(-1+""));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtMilkInvalid(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtMilk("Blah"));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtMilkEmptyInput(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtMilk(""));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testGetAmtSugar(){
        a.assertEquals(7,recipe.getAmtSugar());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtSugar() throws RecipeException {
        recipe.setAmtSugar("11");
        a.assertEquals(11,recipe.getAmtSugar());
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtSugarNegativeNumber(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtSugar(-1+""));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtSugarInvalid(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtSugar("Blah"));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testSetAmtSugarEmptyInput(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtSugar(""));
    }
    /**
     * @Test Case ID:
     */
    @Test
    void testGetName(){
        a.assertEquals("name",recipe.getName());
    }
    /**
     * @Test Case ID: 22
     */
    @Test
    void testSetName(){
        recipe.setName("New");
        a.assertEquals("New",recipe.getName());
    }
    /**
     * @Test Case ID: 23
     */
    @Test
    void testSetNameNull(){
        recipe.setName(null);
        a.assertNotNull(recipe.getName());
    }
    /**
     * @Test Case ID: 24
     */
    @Test
    void testGetPrice(){
        a.assertEquals(50,recipe.getPrice());
    }
    /**
     * @Test Case ID: 25
     */
    @Test
    void testSetPrice() throws RecipeException {
        recipe.setPrice("55");
        a.assertEquals(55,recipe.getPrice());
    }
    /**
     * @Test Case ID: 26
     */
    @Test
    void testSetPriceNegativeNumber(){
        a.assertThrows(RecipeException.class, () -> recipe.setPrice(-1+""));
    }
    /**
     * @Test Case ID: 27
     */
    @Test
    void testSetPriceInvalid(){
        a.assertThrows(RecipeException.class, () -> recipe.setPrice("Blah"));
    }
    /**
     * @Test Case ID: 28
     */
    @Test
    void testSetPriceEmptyInput(){
        a.assertThrows(RecipeException.class, () -> recipe.setPrice(""));
    }
    /**
     * @Test Case ID: 29
     */
    @Test
    void testToString(){
        a.assertEquals(recipe.getName(),recipe.toString());
    }
    /**
     * @Test Case ID: 30
     */
    @Test
    void testHashCode(){
        a.assertTrue(recipe.hashCode() == recipe2.hashCode());
        a.assertTrue(recipe.equals(recipe2) && recipe2.equals(recipe));
    }
    /**
     * @Test Case ID: 31
     */
    @Test
    void testEqualsValid() throws RecipeException {
//        a.assertEquals(recipe,recipe2);
//        a.assertEquals(recipe2,recipe);
        Recipe recipe3 = new Recipe();
        recipe3.setAmtChocolate("5");
        recipe3.setAmtCoffee("10");
        recipe3.setAmtMilk("8");
        recipe3.setAmtSugar("7");
        recipe3.setName("name");
        recipe3.setPrice("50");
        a.assertEquals(recipe, recipe3);

        recipe2 = recipe;
        a.assertEquals(recipe, recipe2);
    }
    /**
     * @Test Case ID: 32
     */
    @Test
    void testEqualsNull(){
        recipe2 = null;
        a.assertFalse(recipe.equals(recipe2));
    }
    /**
     * @Test Case ID: 33
     */
    @Test
    void testEqualsReturnFalse(){
        recipe2.setName("new name");
        a.assertFalse(recipe.equals(recipe2));
    }

    /**
     * @Test Case ID: 34
     */
    @Test
    void testEqualsGetClass() {

        Inventory inv = new Inventory();
        a.assertFalse(recipe.equals(inv));
    }

}
