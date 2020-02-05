package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author unitTesters
 *
 * Unit tests for Inventory class.
 */
public class InventoryTest {

	Inventory i;
	Assertions a;
	int randNum = -1;
	Recipe r;


	@BeforeEach
	void setUp() throws RecipeException {
		randNum = 1 + (int) Math.abs(Math.random()*99); //generate positive integer
		i = new Inventory();

		r = new Recipe();
		r.setAmtChocolate("10");
		r.setAmtCoffee("10");
		r.setAmtMilk("10");
		r.setAmtSugar("10");

	}

	@AfterEach
	void tearDown() {

	}

	@Test
	void getChocolate() {
		a.assertEquals(15, i.getChocolate());
	}

	@Test
	void setChocolate() {
		i.setChocolate(randNum);
		a.assertEquals(randNum, i.getChocolate());
	}

	@Test
	void addChocolate() {
		try {
			int initial = i.getChocolate();
			i.addChocolate(randNum + "");
			a.assertEquals(initial + randNum, i.getChocolate());
		} catch (InventoryException e){
			a.fail("Threw InventoryException error, when presented with a positive integer");
		}
	}

	@Test
	void addNegativeToChocolate() {
		a.assertThrows(InventoryException.class, () -> i.addChocolate(-1+""));
	}

	@Test
	void addInvalidToChocolate() {
		a.assertThrows(InventoryException.class, () -> i.addChocolate("Seven"));
	}

	@Test
	void getCoffee() {
		a.assertEquals(15, i.getCoffee());
	}

	@Test
	void setCoffee() {
		i.setCoffee(randNum);
		a.assertEquals(randNum, i.getCoffee());
	}

	@Test
	void addCoffee() {
		try {
			int initial = i.getCoffee();
			i.addCoffee(randNum + "");
			a.assertEquals(initial + randNum, i.getCoffee());
		} catch (InventoryException e){
			a.fail("Threw InventoryException error, when presented with a positive integer");
		}
	}

	@Test
	void addNegativeToCoffee() {
		a.assertThrows(InventoryException.class, () -> i.addCoffee(-1+""));
	}

	@Test
	void addInvalidToCoffee() {
		a.assertThrows(InventoryException.class, () -> i.addCoffee("Seven"));
	}

	@Test
	void getMilk() {
		a.assertEquals(15, i.getMilk());
	}

	@Test
	void setMilk() {
		i.setMilk(randNum);
		a.assertEquals(randNum, i.getMilk());
	}

	@Test
	void addMilk() {
		try {
			int initial = i.getMilk();
			i.addMilk(randNum + "");
			a.assertEquals(initial + randNum, i.getMilk());
		} catch (InventoryException e){
			a.fail("Threw InventoryException error, when presented with a positive integer");
		}
	}

	@Test
	void addNegativeToMilk() {
		a.assertThrows(InventoryException.class, () -> i.addMilk(-1+""));
	}

	@Test
	void addInvalidToMilk() {
		a.assertThrows(InventoryException.class, () -> i.addMilk("Seven"));
	}

	@Test
	void getSugar() {
		a.assertEquals(15, i.getSugar());
	}

	@Test
	void setSugar() {
		i.setSugar(randNum);
		a.assertEquals(randNum, i.getSugar());
	}

	@Test
	void addSugar() {
		try {
			int initial = i.getSugar();
			i.addSugar(randNum + "");
			a.assertEquals(initial + randNum, i.getSugar());
		} catch (InventoryException e){
			a.fail("Threw InventoryException error, when presented with a positive integer");
		}
	}

	@Test
	void addNegativeToSugar() {
		a.assertThrows(InventoryException.class, () -> i.addSugar(-1+""));
	}

	@Test
	void addInvalidToSugar() {
		a.assertThrows(InventoryException.class, () -> i.addSugar("Seven"));
	}

	@Test
	void enoughIngredients() throws RecipeException {

		a.assertTrue(i.enoughIngredients(r));

		r.setAmtChocolate("16");
		a.assertFalse(i.enoughIngredients(r));

		r.setAmtChocolate("15");
		r.setAmtCoffee("16");
		a.assertFalse(i.enoughIngredients(r));

		r.setAmtCoffee("15");
		r.setAmtMilk("16");
		a.assertFalse(i.enoughIngredients(r));

		r.setAmtMilk("15");
		r.setAmtSugar("16");
		a.assertFalse(i.enoughIngredients(r));
	}

	@Test
	void useIngredients() {
		a.assertTrue(i.useIngredients(r));

		a.assertEquals(5, i.getChocolate());
		a.assertEquals(5, i.getCoffee());
		a.assertEquals(5, i.getMilk());
		a.assertEquals(5, i.getSugar());

		a.assertFalse(i.useIngredients(r));
	}

	@Test
	void testToString() {
		a.assertEquals("Coffee: 15\n" +
				"Milk: 15\n" +
				"Sugar: 15\n" +
				"Chocolate: 15\n", i.toString());
	}
}
