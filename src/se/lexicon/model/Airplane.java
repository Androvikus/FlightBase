package se.lexicon.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Airplane {
	private List<Seat> seats;
	private int maxNrSeats;
	
	/**
	 * Also creates seats for the airplane
	 * @param maxNrSeats
	 */
	public Airplane() {//maxNrSeats was before
		super();
		seats = new ArrayList<>(maxNrSeats);
		//this.maxNrSeats = maxNrSeats;
		createSeats();
	}
	
	//Create seats
	private void createSeats() {
		for(int i=0; i<5; i++) {
			seats.add(new Seat(ComfortType.BUSINESS, 20000));
		}
		for(int i=0; i<5; i++) {
			seats.add(new Seat(ComfortType.ECONOMY, 5000));
		}
	}
	
	
//	boolean putCustomerOnFirstAvailableWithSpecifiedType(Customer customer, ComfortType desiredComfortType) {
//
//		int startIndex;
//		int endIndex;
//		boolean returnValue=false;
//		
//		if(desiredComfortType==ComfortType.BUSINESS) {
//			startIndex=0;
//		}
//		else if(desiredComfortType==ComfortType.ECONOMY) {
//			startIndex=5;
//		}
//		else {
//			startIndex = 5;
//		}
//		
//		endIndex = startIndex+5;
//		
//		//Go through the wanted segment of seat array
//		for(int i=startIndex; i<endIndex; i++) {
//			//if the seat is available, take it, and stop looking
//			if(putCustomerOnDesiredSeatAndType(i, customer, desiredComfortType)) {
//				returnValue = true;
//				break;//should go out of for-loop
//			}
//			//else mark the returnValue as false and keep looking
//			else {
//				returnValue = false;
//			}
//		}
//			
//		
//		//after all search is done, return returnValue
//		return returnValue;
//	}
//	
//	
//	public boolean putCustomerOnDesiredSeatAndType(int index, Customer customer, ComfortType desiredComfortType) {
//		try {
//			if(seats.get(index).getCustomer()==null && seats.get(index).getComfortType() == desiredComfortType) {
//				seats.get(index).setCustomer(customer);
//				return true;
//			}
//			else {
//				//System.out.println("Seat is taken");
//			}
//		}
//		catch (Exception e) {
//			System.out.println("");
//		}
//		return false;
//	}
	
	/**
	 * Tries to put customer on a seat of the desired ComfortType
	 * @param customer
	 * @param desiredComfortType
	 * @return
	 */
	public boolean putCustomerOnDesiredSeatType(Customer customer, ComfortType desiredComfortType) {
		Iterator<Seat> ite = seats.iterator();
		while(ite.hasNext()) {
			Seat tempSeat = ite.next();
			if(tempSeat.getComfortType() == desiredComfortType && tempSeat.getCustomer() == null) {
				tempSeat.setCustomer(customer);
				return true;
			}
		}
		return false;
	}

	public List<Seat> getSeats() {
		return Collections.unmodifiableList(seats);
	}
	
}
