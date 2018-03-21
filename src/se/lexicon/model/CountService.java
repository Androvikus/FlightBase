package se.lexicon.model;

import java.util.Iterator;
import java.util.List;

public class CountService {

	private int foodAndTicketSum;
	private int foodAndTicketSumPerCustomer;
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
			if (tempSeat.getCustomer() != null) {
				totalPrice += tempSeat.getPrice();
				if(tempSeat.getCustomer().getDish() != null) {
					totalFoodPrice += tempSeat.getCustomer().getDish().getPrice();
				}
			}
		}
		foodAndTicketSum = totalPrice + totalFoodPrice;
	}


	private void sumOfTicketPriceAndFoodPricePerCustomer(Seat seat) {
		int dishPrice;
		int ticketPrice;
		dishPrice = seat.getCustomer().getDish().getPrice();
		ticketPrice = seat.getPrice();
		foodAndTicketSumPerCustomer = dishPrice + ticketPrice;	
	}


	public double countProfitPerFlight (List <Seat> airplaneSeats) {
		//double profit;
		//profit 

		return (double) (getFoodAndTicketSumPerFlight(airplaneSeats))*0.3;

	}

	public int getFoodAndTicketSumPerFlight(List<Seat> airplaneSeats) {
		sumUpTotalTicketPrices(airplaneSeats);

		return foodAndTicketSum;
	}

	
	public int getFoodAndTicketSumPerCustomer() {

		return foodAndTicketSumPerCustomer;
	}
}
