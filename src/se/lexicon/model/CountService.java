package se.lexicon.model;

import java.util.Iterator;
import java.util.List;

public class CountService {

	private double foodAndTicketSum;
	private double foodAndTicketSumPerCustomer;
	private List<Seat> airplaneSeats;

	public CountService() {

	}

	public void sumUpTotalTicketPrices(List<Seat> airplaneSeats) {

		//Total sum every booked seat. Booked = has customer
		Iterator<Seat> seatIterator = airplaneSeats.iterator();
		int totalPrice = 0;
		int totalFoodPrice = 0;
		while (seatIterator.hasNext()) {
			Seat tempSeat = seatIterator.next();
			if ((tempSeat.getCustomer() != null)) {
				totalPrice += tempSeat.getPrice();
				totalFoodPrice += tempSeat.getCustomer().getDish().getPrice();
			}
		}
			foodAndTicketSum = totalPrice + totalFoodPrice;
		}
		

	
	private void sumOfTicketPriceAndFoodPricePerCustomer(Customer customer, Seat seat) {
		int dishPrice;
		int ticketPrice;
		dishPrice = customer.getDish().getPrice();
		ticketPrice = seat.getPrice();
		foodAndTicketSumPerCustomer = dishPrice + ticketPrice;	
	}

	public double getFoodAndTicketSumPerFlight(List<Seat> airplaneSeats) {
		sumUpTotalTicketPrices(airplaneSeats);
		
		return foodAndTicketSum;
	}

	public double getTotalTicketAmount() {
		return foodAndTicketSumPerCustomer;
	}
	
	
	
}
