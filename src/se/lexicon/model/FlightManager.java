package se.lexicon.model;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The managing class of the project
 * Creates an airplane with 10 seats automatic
 * @author Dator
 *
 */
public class FlightManager {
	
	Airplane airplane = new Airplane();
	FoodService foodService = new FoodService();//Far matratter inskrivet
	CountAndReceiptService countService = new CountAndReceiptService();
	
	public final static int BUSINESS_PRICE = 20000;
	public final static int ECONOMY_PRICE = 5000;
	
	
	public boolean addCustomer(Customer customerToAdd, ComfortType desiredComfortType) throws Exception 
	{
		if (customerToAdd == null) 
		{
			throw new IllegalArgumentException(
					"Parameter customerToAdd must not be null.");
		}
		return airplane.putCustomerOnDesiredSeatType(customerToAdd, desiredComfortType);
	}
	
	public boolean canAddCustomer(ComfortType desiredComfortType) {
		return airplane.canPutCustomerOnDesiredSeatType(desiredComfortType);
	}
	
	public int getNumberOfSeats() {
		return airplane.getNumberOfSeats();
	}
	
	public List<Seat> getAllSeats()
	{
		return Collections.unmodifiableList(airplane.getSeats());
	}
	
	public int getNumberOfAvailableSeats() {
		return getNumberOfSeats() - getNumberOfCustomers();
	}
	
	public List<Seat> getSeatsByComfortType(ComfortType comfortType){
		return airplane.getSeats().stream().filter(s -> s.getComfortType() == comfortType).collect(Collectors.toList());
	}
	
	public Seat getSeatAt(int index) {
		return airplane.getSeats().get(index);
	}
	
	public int getNumberOfCustomers() {
		return airplane.getNumberOfCustomers();
	}
	
	//Food section
	public boolean assignDishToCustomer(Customer customer, Dish dish) {

		for(Seat seat : airplane.getSeats()) {//TODO: forenkla sokning
			System.out.println("Kollar seat " + seat);
			if(seat.getCustomer()!=null && seat.getCustomer().equals(customer)) {

				System.out.println("Customer " + customer  + " equals " + seat.getCustomer());
				if(foodService.getDishesByComfortType(seat.getComfortType()).contains(dish)) {
					//System.out.println("Dish " + dish + " aterfanns i dishes med CT " + seat.getComfortType());
					//Om foreslagen matratt finns Bland alla matratter som har samma ComfortType som kundens (sates) ComfortType
					//Da godkanns tilldelning
					customer.setDish(dish);
					return true;
				}
				else {
					System.out.println("Dish aterfanns ej");
				}
			}
			else {
				System.out.println("Customer " + customer + " ej equals " + seat.getCustomer());
			}
		}
		System.out.println("Ska returnera false");
		return false;
	}
	
	public boolean assignDishToCustomerWithComfortType(Customer customer, Dish dish, ComfortType comfortType) {
		
		if(foodService.getDishesByComfortType(comfortType).contains(dish)) {
			//System.out.println("Dish " + dish + " aterfanns i dishes med CT " + comfortType);
			//Om foreslagen matratt finns Bland alla matratter som har samma ComfortType som kundens (sates) ComfortType
			//Da godkanns tilldelning
			customer.setDish(dish);
			return true;
		}
		else {
			System.out.println("Dish not found");
		}
			
		System.out.println("Something went wrong");
		return false;
	}
	
	/**
	 * 
	 * @return - an unmodifiable List
	 */
	public List<Dish> getAvailableDishes(){
		return foodService.getAllDishes();
	}
	
	public List<Dish> getAvailableDishesByComfortType(ComfortType comfortType){
		return foodService.getDishesByComfortType(comfortType);
	}

	//end food section
	
	//Count section
	
	public double getTotalFlightPrice(List<Seat> allSeats) {
		return  countService.getFoodAndTicketSumPerFlight(allSeats);		
	}
	
	public double countProfitPerFlight(List<Seat> seats) {
		return countService.countProfitPerFlight(seats);
	}
	
	//end count section
	
	public void presentReceipt(Customer cust, ComfortType comfType, Seat seat) {
		//TODO: Call countService
		countService.presentReceipt(cust, comfType, seat);
	}
}
