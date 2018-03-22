package se.lexicon.model;

public class Dish {
	ComfortType comfortType;
	private String title;
	private String description;
	private int price;
	
	
	public Dish(ComfortType comfortType, String title, String description, int price) {
		super();
		this.comfortType = comfortType;
		this.title = title;
		this.description = description;
		this.price = price;
	}


	/**
	 * @return the comfortType
	 */
	public ComfortType getComfortType() {
		return comfortType;
	}


	/**
	 * @param comfortType the comfortType to set
	 */
	public void setComfortType(ComfortType comfortType) {
		this.comfortType = comfortType;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  title + " description " + " price "
				+ " price ";
	}
	
	
	
	
	
	
}
