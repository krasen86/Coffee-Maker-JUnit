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
 *zz
 * Unit tests for Inventory class.
 */
public class InventoryTest {

	private Inventory i;
	private Assertions a;
	private int randNum = -1;
	private Recipe r;


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

	/**
	 * @Test Case ID: 62
	 */
	@Test
	void getChocolate() {
		a.assertEquals(15, i.getChocolate());
	}

	/**
	 * @Test Case ID: 63
	 */
	@Test
	void setChocolate() {
		i.setChocolate(randNum);
		a.assertEquals(randNum, i.getChocolate());
	}

	/**
	 * @Test Case ID: 64
	 */
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

	/**
	 * @Test Case ID: 65
	 */
	@Test
	void addNegativeToChocolate() {
		a.assertThrows(InventoryException.class, () -> i.addChocolate(-1+""));
	}

	/**
	 * @Test Case ID: 66
	 */
	@Test
	void addInvalidToChocolate() {
		a.assertThrows(InventoryException.class, () -> i.addChocolate("Seven"));
	}

	/**
	 * @Test Case ID: 67
	 */
	@Test
	void getCoffee() {
		a.assertEquals(15, i.getCoffee());
	}

	/**
	 * @Test Case ID: 68
	 */
	@Test
	void setCoffee() {
		i.setCoffee(randNum);
		a.assertEquals(randNum, i.getCoffee());
	}
	/**
	 * @Test Case ID: 69
	 */
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
	/**
	 * @Test Case ID: 70
	 */
	@Test
	void addNegativeToCoffee() {
		a.assertThrows(InventoryException.class, () -> i.addCoffee(-1+""));
	}
	/**
	 * @Test Case ID: 71
	 */
	@Test
	void addInvalidToCoffee() {
		a.assertThrows(InventoryException.class, () -> i.addCoffee("Seven"));
	}
	/**
	 * @Test Case ID: 72
	 */
	@Test
	void getMilk() {
		a.assertEquals(15, i.getMilk());
	}
	/**
	 * @Test Case ID: 73
	 */
	@Test
	void setMilk() {
		i.setMilk(randNum);
		a.assertEquals(randNum, i.getMilk());
	}
	/**
	 * @Test Case ID: 74
	 */
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
	/**
	 * @Test Case ID: 75
	 */
	@Test
	void addNegativeToMilk() {
		a.assertThrows(InventoryException.class, () -> i.addMilk(-1+""));
	}
	/**
	 * @Test Case ID: 76
	 */
	@Test
	void addInvalidToMilk() {
		a.assertThrows(InventoryException.class, () -> i.addMilk("Seven"));
	}
	/**
	 * @Test Case ID: 77
	 */
	@Test
	void getSugar() {
		a.assertEquals(15, i.getSugar());
	}
	/**
	 * @Test Case ID: 78
	 */
	@Test
	void setSugar() {
		i.setSugar(randNum);
		a.assertEquals(randNum, i.getSugar());
	}
	/**
	 * @Test Case ID: 79
	 */
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
	/**
	 * @Test Case ID: 80
	 */
	@Test
	void addNegativeToSugar() {
		a.assertThrows(InventoryException.class, () -> i.addSugar(-1+""));
	}
	/**
	 * @Test Case ID: 81
	 */
	@Test
	void addInvalidToSugar() {
		a.assertThrows(InventoryException.class, () -> i.addSugar("Seven"));
	}
	/**
	 * @Test Case ID: 82
	 */
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
	/**
	 * @Test Case ID: 83
	 */
	@Test
	void useIngredients() {
		a.assertTrue(i.useIngredients(r));
		a.assertEquals(5, i.getChocolate());
		a.assertEquals(5, i.getCoffee());
		a.assertEquals(5, i.getMilk());
		a.assertEquals(5, i.getSugar());

		a.assertFalse(i.useIngredients(r));
	}
	/**
	 * @Test Case ID: 84
	 */
	@Test
	void testToString() {
		a.assertEquals("Coffee: 15\n" +
				"Milk: 15\n" +
				"Sugar: 15\n" +
				"Chocolate: 15\n", i.toString());
	}

}
