package entity;

import java.io.Serializable;

/**
 * @author zhou
 *
 */
public class OrderItem implements Serializable{
	
	/**
	 * Version UID
	 */
	private static final long serialVersionUID = -2045284274757476315L;
	
	/**
	 * quantity of the menu item
	 */
	private int quantity;
	
	/**
	 * the menuitem being ordered
	 */
	private MenuItem item;
	
	/**
	 * get Quantity
	 * @return number of item ordered
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * set quantity
	 * @param quantity to be set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * getter for item
	 * @return the menu item
	 */
	public MenuItem getItem() {
		return item;
	}
	
	/**
	 * 
	 * @param quantity
	 * @param item
	 */
	public OrderItem(int quantity, MenuItem item) {
		this.quantity = quantity;
		this.item = item;
	}
	
	/*
	 * obtain price 
	 */
	public double getTotalPrice() {
		return item.getPrice()*quantity;
	}
	
	
	/*
	 * 5 \t name 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%d \t\t %s \t %.2f*%d = %.2f", quantity,item.getName(),item.Price,quantity,getTotalPrice());		
	}
}
