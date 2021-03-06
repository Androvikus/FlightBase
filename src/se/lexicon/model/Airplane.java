package se.lexicon.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Airplane {
	private List<Seat> seats;
	private int maxNrSeats=10;
	private int numberOfBusinessSeats=5;//TODO: byt till 5
	private int numberOfEconomySeats=5;//TODO: byt till 5
	
	/**
	 * Also creates seats for the airplane
	 * @param maxNrSeats
	 */
	public Airplane() {//maxNrSeats was before
		seats = new ArrayList<>(maxNrSeats);
		//this.maxNrSeats = maxNrSeats;
		createSeats(numberOfBusinessSeats,numberOfEconomySeats);
	}
	
	public Airplane(int nrOfBusinessSeats, int nrOfEconomySeats) {
		seats = new ArrayList<>(nrOfBusinessSeats + nrOfEconomySeats);
		createSeats(nrOfBusinessSeats, nrOfEconomySeats);
	}
	
	
	private void createSeats(int nrOfBusinessSeats, int nrOfEconomySeats) {
		for(int i=0; i<nrOfBusinessSeats; i++) {
			seats.add(new Seat(ComfortType.BUSINESS));
		}
		for(int i=0; i<nrOfEconomySeats; i++) {
			seats.add(new Seat(ComfortType.ECONOMY));
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
	
	public int getNumberOfSeats() {
		return seats.size();
	}

	public boolean canPutCustomerOnDesiredSeatType(ComfortType desiredComfortType) {
		Iterator<Seat> ite = seats.iterator();
		while(ite.hasNext()) {
			Seat tempSeat = ite.next();
			if(tempSeat.getComfortType() == desiredComfortType && tempSeat.getCustomer() == null) {
				return true;
			}
		}
		return false;
	}
	
	public int getNumberOfCustomers() {
		int counter = 0;
		for(Seat seat: seats) {
			if(seat.getCustomer()!=null) {
				counter++;
			}
		}
		return counter;
	}
	
}
