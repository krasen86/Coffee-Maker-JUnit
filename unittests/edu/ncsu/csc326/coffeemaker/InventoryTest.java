package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
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

	@BeforeEach
	void setUp() {
		randNum = 1 + (int) Math.abs(Math.random()*99); //generate positive integer
		i = new Inventory();

		i.setCoffee(10);
		i.setMilk(10);
		i.setSugar(10);
		i.setCoffee(10);
	}

	@AfterEach
	void tearDown() {

	}

	@Test
	void getChocolate() {
		a.assertEquals(10, i.getChocolate());
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
		a.assertEquals(10, i.getCoffee());
	}

	@Test
	void setCoffee() {

	}

	@Test
	void addCoffee() {
	}

	@Test
	void getMilk() {
	}

	@Test
	void setMilk() {
	}

	@Test
	void addMilk() {
	}

	@Test
	void getSugar() {
	}

	@Test
	void setSugar() {
	}

	@Test
	void addSugar() {
	}

	@Test
	void enoughIngredients() {
	}

	@Test
	void useIngredients() {
	}

	@Test
	void testToString() {
	}
}
