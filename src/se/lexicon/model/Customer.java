package se.lexicon.model;

public class Customer {
	private int id;
	private String firstName;
	private String Surname;
	private Dish dish;
	
	static int customerCount;
	
	public Customer() {
		customerCount++;
		id = customerCount;
	}
	
	public Customer(String firstName) {
		customerCount++;
		this.firstName = firstName;
		id = customerCount;
	}
	
	public Customer(String firstName, String surname, Dish dish) {
		customerCount++;
		this.firstName = firstName;
		Surname = surname;
		this.dish = dish;
		id = customerCount;
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

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", Surname=" + Surname + ", dish=" + dish + "]";
	}
	
	
	
}
