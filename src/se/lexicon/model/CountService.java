package se.lexicon.model;

import java.util.Iterator;
import java.util.List;

public class CountService {

	private double foodAndTicketSum;
	private double totalTicketAmount;
	private List<Seat> airplaneSeats;
	
	private void sumUpTotalTicketPrices(List<Seat> airplaneSeats) {
		
	//Total sum every booked seat. Booked = has customer
	Iterator<Seat> seatIterator = airplaneSeats.iterator();
	int totalPrice = 0;
	int totalFoodPrice = 0;
	while (seatIterator.hasNext() && (seatIterator.next().getCustomer() != null)) {
		totalPrice += seatIterator.next().getPrice();
		totalFoodPrice += seatIterator.next().getCustomer().getDish().getPrice();
		foodAndTicketSum = totalPrice + totalFoodPrice;
	}
		
	}
	
	private void sumOfTicketPriceAndFoodPricePerCustomer(Customer customer, Seat seat) {
		int dishPrice;
		int ticketPrice;
		dishPrice = customer.getDish().getPrice();
		ticketPrice = seat.getPrice();
		totalTicketAmount = dishPrice + ticketPrice;	
	}

	public double getFoodAndTicketSum() {
		return foodAndTicketSum;
	}

	public double getTotalTicketAmount() {
		return totalTicketAmount;
	}
	
	
	
}
