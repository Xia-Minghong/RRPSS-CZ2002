package entity;


import java.io.Serializable;

/**
 * AlaCarte is a model class which holds the relevant attributes
 * of a AlaCarte and provides the mutators and accessors accordingly
 * @author Cao Gaoxu
 *@version1.0
 *@since 2014-11-06
 */

public class AlaCarte extends MenuItem implements Serializable{
	
	/**
	 * the price of the Ala Carte
	 */
	private double Price;
	
	/**
	 * Constructor of the Ala Carte class
	 * @param name, the name of the Ala Carte
	 * @param description, the description of the Ala Carte
	 * @param category, the category of the Ala Carte
	 * @param price, the price of the Ala Carte
	 */
	public AlaCarte(String name, String description, String category, double price){
		super(name,description,category);
		this.Price = price;
	}
	
	/**
	 * Getter method for Ala Carte price
	 * @return price of the Ala Carte
	 */
	public double getPrice(){ 
		return this.Price;
	}

	/**
	 * Setter method for Ala Carte price
	 * @param price, the price to be set to the Ala Carte
	 */
	public void setPrice(double price) {
		this.Price = price;
		
	}
	
	/**
	 * Format the Ala Carte's attributes to print
	 */
	@Override
	public String toString(){
		StringBuffer ans = new StringBuffer();
		ans.append("Type: \t\t\tAla Carte\nName:\t\t\t"+this.getName()+"\n"+"Category:\t\t"+ this.getCategory() +"\n"+"Description:\t\t"+ this.getDescription()+"\n"+"Price:\t\t\t"+this.Price);
		return ans.toString();
	}
	
}

