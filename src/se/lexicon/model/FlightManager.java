package se.lexicon.model;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * The managing class of the project
 * Creates an airplane with 10 seats automatic
 * @author Dator
 *
 */
public class FlightManager {
	
	Airplane airplane = new Airplane(10);
	FoodService foodService = new FoodService();//Får maträtter inskrivet
	
	
	public void addCustomer(Customer customerToAdd, ComfortType desiredComfortType) throws Exception 
	{
		if (customerToAdd == null) 
		{
			throw new IllegalArgumentException(
					"Parameter customerToAdd must not be null.");
		}
		airplane.putCustomerOnFirstAvailableWithSpecifiedType(customerToAdd, desiredComfortType);
	}
	
	
	public List<Seat> getAllSeats()
	{
		return Collections.unmodifiableList(airplane.getAllSeats());
	}
	
	//Food section
	public boolean assignDishToCustomer(Customer customer, Dish dish) {
		for(Seat seat : airplane.getAllSeats()) {//TODO: förenkla sökning
			System.out.println("Kollar säte " + seat);
			if(seat.getCustomer()!=null && seat.getCustomer().equals(customer)) {
				System.out.println("Customer " + customer  + " equals " + seat.getCustomer());
				if(foodService.getDishesByComfortType(seat.getComfortType()).contains(dish)) {
					System.out.println("Dish " + dish + " återfanns i dishes med CT " + seat.getComfortType());
					//Om föreslagen maträtt finns Bland alla maträtter som har samma ComfortType som kundens (sätes) ComfortType
					//Då godkänns tilldelning
					customer.setDish(dish);
					return true;
				}
				else {
					System.out.println("Dish återfanns ej");
				}
			}
			else {
				System.out.println("Customer " + customer + " ej equals " + seat.getCustomer());
			}
		}
		System.out.println("Ska returnera false");
		return false;
	}
	
	/**
	 * 
	 * @return - an unmodifiable List
	 */
	public List<Dish> getAvailableDishes(){
		return foodService.getAllDishes();
	}
	
	//end food section
}
