package entity;

public class OrderItem {
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
	public double getTotalPrice() {
		return item.getPrice()*quantity;
	}
	
}
