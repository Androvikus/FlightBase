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
	
	@Test
	public void testCountOneCustomerFlightPrice() {
		//Take an existent dish
		Dish dish = fm.getAvailableDishes().get(0);
		//Fetch the placed customer
		cust = fm.getSeatAt(0).getCustomer();
		//Assign a dish to costumer
		fm.assignDishToCustomer(cust, dish);//hoppas funkar
		
		int expectedPrice = FlightManager.BUSINESS_PRICE + dish.getPrice();
		//assert that the price is as expected
		assertTrue(expectedPrice == fm.getTotalFlightPrice(fm.getAllSeats()));
	}
	
	@Test
	public void testProfitFromOneCustomerAmount() {
		Dish dish = fm.getAvailableDishes().get(0);
		cust = fm.getSeatAt(0).getCustomer();
		fm.assignDishToCustomer(cust, dish);
		
		
		
		double expectedProfit = (FlightManager.BUSINESS_PRICE + dish.getPrice()) * 0.3;
		
		assertTrue(expectedProfit == fm.countProfitPerFlight(fm.getAllSeats()));
		
	}
	

}
