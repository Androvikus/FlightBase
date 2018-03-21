package se.lexicon.model;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


/**
 * The managing class of the project
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
	
	
	public List<Seat> getAllSeats() throws ClassNotFoundException 
	{
		return airplane.getAllSeats();
	}
	
	public boolean assignDishToCustomer(Customer customer, Dish dish) {
		for(Seat seat : airplane.getAllSeats()) {
			if(seat.getCustomer().equals(customer)) {
				if(foodService.getDishesByComfortType(seat.getComfortType()).contains(dish)) {
					//Om föreslagen maträtt finns Bland alla maträtter som har samma ComfortType som kundens (sätes) ComfortType
					//Då godkänns tilldelning
					customer.setDish(dish);
					return true;
				}
			}
		}
		return false;
	}
}
