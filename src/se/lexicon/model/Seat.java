package se.lexicon.model;

public class Seat {
	private Customer customer;
	private ComfortType comfortType;
	private int price;
	private int seatNumber;
	
	public static int seatCounter;
	
//	public Seat(Customer customer, ComfortType comfortType, int price) {
//		super();
//		this.customer = customer;
//		this.comfortType = comfortType;
//		this.price = price;
//	}
	
//	public Seat(ComfortType comfortType, int price) {
//		this.comfortType = comfortType;
//		this.price = price;
//		seatCounter++;
//		seatNumber = seatCounter;
//	}
	
	public Seat(ComfortType comfortType){
		this.comfortType = comfortType;
		
		if(comfortType == ComfortType.BUSINESS) {
			price = FlightManager.BUSINESS_PRICE;
		}
		else if(comfortType == ComfortType.ECONOMY) {
			price = FlightManager.ECONOMY_PRICE;
		}
		
		seatCounter++;
		seatNumber = seatCounter;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	/**
	 * @return the comfortType
	 */
	public ComfortType getComfortType() {
		return comfortType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Seat [customer=" + customer + ", comfortType=" + comfortType + ", price=" + price + "]";
	}

}
