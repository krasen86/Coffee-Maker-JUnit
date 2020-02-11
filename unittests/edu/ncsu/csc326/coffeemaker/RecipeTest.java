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

    @Test
    void testGetAmtChocolatePositiveInt(){
        a.assertEquals(5,recipe.getAmtChocolate());
    }

    @Test
    void testSetAmtChocolate() {
        try {
            recipe.setAmtChocolate("12");
            a.assertEquals(12, recipe.getAmtChocolate());
        } catch (RecipeException e) {
            a.fail("RecipeException was thrown, due to an invalid input!");
        }
    }

    @Test
    void testSetAmtChocolateNegativeNumber(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtChocolate(-1+""));
    }

    @Test
    void testSetAmtChocolateInvalid(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("Blah"));
    }

    @Test
    void testSetAmtChocolateNoInput(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtChocolate(""));
    }

    @Test
    void testGetAmtCoffee(){
        a.assertEquals(10,recipe.getAmtCoffee());
    }

    @Test
    void testSetAmtCoffee() {
        try {
            recipe.setAmtCoffee("17");
            a.assertEquals(17, recipe.getAmtCoffee());
        } catch (RecipeException e) {
            a.fail("RecipeException was thrown, due to an invalid input!");
        }
    }

    @Test
    void testSetAmtCoffeeNegativeNumber(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtCoffee(-1+""));
    }

    @Test
    void testSetAmtCoffeeInvalid(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("Blah"));
    }

    @Test
    void testSetAmtCoffeeEmptyInput(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtCoffee(""));
    }

    @Test
    void testGetAmtMilk(){
        a.assertEquals(8,recipe.getAmtMilk());
    }

    @Test
    void testSetAmtMilk() {
        try {
        recipe.setAmtMilk("9");
        a.assertEquals(9,recipe.getAmtMilk());
        } catch (RecipeException e) {
            a.fail("RecipeException was thrown, due to an invalid input!");
        }
    }

    @Test
    void testSetAmtMilkNegativeNumber(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtMilk(-1+""));
    }

    @Test
    void testSetAmtMilkInvalid(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtMilk("Blah"));
    }

    @Test
    void testSetAmtMilkEmptyInput(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtMilk(""));
    }

    @Test
    void testGetAmtSugar(){
        a.assertEquals(7,recipe.getAmtSugar());
    }

    @Test
    void testSetAmtSugar() {
        try {
            recipe.setAmtSugar("11");
            a.assertEquals(11, recipe.getAmtSugar());
        } catch (RecipeException e) {
            a.fail("RecipeException was thrown, due to an invalid input!");
        }
    }

    @Test
    void testSetAmtSugarNegativeNumber(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtSugar(-1+""));
    }

    @Test
    void testSetAmtSugarInvalid(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtSugar("Blah"));
    }

    @Test
    void testSetAmtSugarEmptyInput(){
        a.assertThrows(RecipeException.class, () -> recipe.setAmtSugar(""));
    }

    @Test
    void testGetName(){
        a.assertEquals("name",recipe.getName());
    }

    @Test
    void testSetName(){
        recipe.setName("New");
        a.assertEquals("New",recipe.getName());
    }

    @Test
    void testSetNameNull(){
        recipe.setName(null);
        a.assertNotNull(recipe.getName());
    }

    @Test
    void testGetPrice(){
        a.assertEquals(50,recipe.getPrice());
    }

    @Test
    void testSetPrice() {
        try {
        recipe.setPrice("55");
        a.assertEquals(55,recipe.getPrice());
        } catch (RecipeException e) {
            a.fail("RecipeException was thrown, due to an invalid input!");
        }
    }

    @Test
    void testSetPriceNegativeNumber(){
        a.assertThrows(RecipeException.class, () -> recipe.setPrice(-1+""));
    }

    @Test
    void testSetPriceInvalid(){
        a.assertThrows(RecipeException.class, () -> recipe.setPrice("Blah"));
    }

    @Test
    void testSetPriceEmptyInput(){
        a.assertThrows(RecipeException.class, () -> recipe.setPrice(""));
    }

    @Test
    void testToString(){
        a.assertEquals(recipe.getName(),recipe.toString());
    }

    @Test
    void testHashCode(){
        a.assertTrue(recipe.hashCode() == recipe2.hashCode());
        a.assertTrue(recipe.equals(recipe2) && recipe2.equals(recipe));
    }

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

    @Test
    void testEqualsNull(){
        recipe2 = null;
        a.assertFalse(recipe.equals(recipe2));
    }

    @Test
    void testEqualsReturnFalse(){
        recipe2.setName("new name");
        a.assertFalse(recipe.equals(recipe2));
    }

    @Test
    void testEqualsGetClass() {

        Inventory inv = new Inventory();
        a.assertFalse(recipe.equals(inv));
    }

//    @Test
//    void testEquals_NullName(){
//        a.assertFalse(recipe.equals(recipe2));
//    }

}
