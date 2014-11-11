package entity;

import java.io.Serializable;

public class OrderItem implements Serializable{
	private int quantity;
	private MenuItem item;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MenuItem getItem() {
		return item;
	}
	public void setItem(MenuItem item) {
		this.item = item;
	}
	
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
