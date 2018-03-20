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
}
