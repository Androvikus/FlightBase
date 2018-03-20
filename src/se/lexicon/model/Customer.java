package se.lexicon.model;

public class Customer {
	private int id;
	private String firstName;
	private String Surname;
	private Dish dish;
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String surname, Dish dish) {
		super();
		this.firstName = firstName;
		Surname = surname;
		this.dish = dish;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return Surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		Surname = surname;
	}

	/**
	 * @return the dish
	 */
	public Dish getDish() {
		return dish;
	}

	/**
	 * @param dish the dish to set
	 */
	public void setDish(Dish dish) {
		this.dish = dish;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	
	
}
