package se.lexicon.modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import se.lexicon.model.ComfortType;
import se.lexicon.model.Customer;
import se.lexicon.model.Dish;
import se.lexicon.model.FlightManager;

public class Test_180321 {
	
	FlightManager fm;
	Customer cust;

	@Before
	public void setUp() throws Exception {
		fm = new FlightManager();
		cust = new Customer("Erik");
		fm.addCustomer(cust, ComfortType.BUSINESS);//index 0
		
	}
	


	@Test
	public void testAssignAvailableDishToCustomer() {
		Dish dish = fm.getAvailableDishes().get(0);
		assertTrue(fm.assignDishToCustomer(cust, dish));
	}
	
	@Test
	public void testAssignUnavailableDishToCustomer() {
		Dish dish = new Dish(ComfortType.ECONOMY, "Linssoppa", "description", 100);
		assertFalse(fm.assignDishToCustomer(cust, dish));
	}

}
