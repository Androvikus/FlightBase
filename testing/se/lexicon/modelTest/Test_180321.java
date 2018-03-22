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
	Customer cust, cust2;

	@Before
	public void setUp() throws Exception {
		fm = new FlightManager();
		cust = new Customer("Erik");
		cust2 = new Customer("Mats");
		fm.addCustomer(cust, ComfortType.BUSINESS);
	}
	

	@Test
	public void testAssignAvailableBusinessDishToCustomer() {
		Dish dish = fm.getAvailableDishes().get(0);
		assertTrue(fm.assignDishToCustomer(cust, dish));
	}
	
	@Test
	public void testAssignAvailableEconomyDishToCustomer() {
		
		try {
			fm.addCustomer(cust2, ComfortType.ECONOMY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dish dish2 = fm.getAvailableDishes().get(3);
		cust2 = fm.getSeatAt(5).getCustomer();		
		
		assertTrue(fm.assignDishToCustomer(cust2, dish2));
	}
	
	@Test
	public void testAssignUnavailableDishToCustomer() {
		Dish dish = new Dish(ComfortType.ECONOMY, "Linssoppa", "description", 100);
		assertFalse(fm.assignDishToCustomer(cust, dish));
	}
	
	@Test
	public void testCountOneCustomerBusinessFlightPrice() {
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
	public void testCountOneCustomerEconomyFlightPrice() {
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
	public void testProfitFromAllCustomerAmount() {
		
		try {
			fm.addCustomer(cust2, ComfortType.ECONOMY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dish dish = fm.getAvailableDishes().get(0);
		cust = fm.getSeatsByComfortType(ComfortType.BUSINESS).get(0).getCustomer();
		fm.assignDishToCustomer(cust, dish);
		
		Dish dish2 = fm.getAvailableDishes().get(3);
		cust2 = fm.getSeatsByComfortType(ComfortType.ECONOMY).get(0).getCustomer();
		fm.assignDishToCustomer(cust2, dish2);//hoppas funkar
		
		
		
		double expectedProfit = (FlightManager.BUSINESS_PRICE + dish.getPrice()) * 0.3;
		expectedProfit += (FlightManager.ECONOMY_PRICE + dish2.getPrice()) * 0.3;
		
		System.out.println(expectedProfit + " ---");
		System.out.println(fm.countProfitPerFlight(fm.getAllSeats()) + " ---");
		
		assertTrue(expectedProfit == fm.countProfitPerFlight(fm.getAllSeats()));
	}
	

}
