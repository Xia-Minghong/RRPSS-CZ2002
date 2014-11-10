package entity;

import java.io.Serializable;

/**
 * MenuItem is a abstract class which holds the attributes of a menuItem 
 * and provides the mutators/setters and accessors/getters accordingly
 * @author Cao Gaoxu
 * @since 2014-11-05
 */
public abstract class MenuItem implements Serializable{
	
	/**
	 * The name of the menuItem
	 */
	private String Name;
	
	/**
	 * the description of the menuItem
	 */
	
	private String Description;
	
	/**
	 * the category of the menuItem
	 */
	
	private String Category;
	
	/**
	 * the price of the menuItem
	 */
		
	protected double Price;
	
	public MenuItem(String name, String description, String category) {
		this.Name = name;
		this.Description = description;
		this.Category = category;
		
	}
	/**
	 * getter method for menuItem's name
	 * @return the name of the menuItem
	 */
	public String getName(){
		return this.Name;
	}
	/**
	 * setter method for the menuItem's name
	 * @param Name the name to set to menuItem
	 */
	public void setName(String Name){
		this.Name = Name;
	}
	
	/**
	 * getter method for the menuItem's description
	 * @return the description of the menuItem 
	 */
	public String getDescription(){
		return this.Description;
	}
	
	/**
	 * setter method for the menuItem's description
	 * @param description, the description to set to menuItem
	 */
	
	public void setDescription(String description){
		this.Description = description;
	}
	
	/**
	 * getter method for menuItem's category
	 * @return the category of the menuItem
	 */
	public String getCategory(){
		return this.Category;
	}
	
	/**
	 * setter method for menuItem's category
	 * @param category, the category to set to menuItem
	 */
	public void setCategory(String category){
		this.Category = category;
	}
	
	/**
	 * abstract getter method for menuItem's price
	 */
	public abstract double getPrice();
	
	/**
	 * abstract setter method for menuItem's price
	 */
	public abstract void setPrice(double price);
	

}
