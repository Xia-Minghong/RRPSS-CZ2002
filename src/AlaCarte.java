

public class AlaCarte extends MenuItem {
	
	/**
	 * the price of the Alacarte
	 */
	private double Price;
	
	/**
	 * Constructor of the Alacarte class
	 * @param name, the name of the Alacarte
	 * @param description, the description of the Alacarte
	 * @param category, the category of the Alacarte
	 * @param price, the price of the Alacarte
	 */
	public AlaCarte(String name, String description, String category, double price){
		super(name,description,category);
		this.Price = price;
	}
	
	/**
	 * Getter method for Alacarte price
	 * @return price of the Alacarte
	 */
	public double getPrice(){ 
		return this.Price;
	}

	/**
	 * Setter method for Alacarte price
	 * @param price, the price to be set to the Alacarte
	 */
	public void setPrice(double price) {
		this.Price = price;
		
	}
	

}
