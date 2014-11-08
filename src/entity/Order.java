package entity;

import java.util.ArrayList;

/**
 * 
 */

/**
 * @author zhou
 *
 */
public class Order {
	private static int orderCount = 0;
	private int staffID, tableID;
	private final int orderID;
	private ArrayList<OrderItem> orderItems;
	
	
	
	public Order(int staffID, int tableID) {
		orderCount ++;
		this.orderID = orderCount;
		this.staffID = staffID;
		this.tableID = tableID;
		orderItems = new ArrayList<OrderItem>();
	}

	

	public static int getOrderCount() {
		return orderCount;
	}



	public int getStaffID() {
		return staffID;
	}



	public int getTableID() {
		return tableID;
	}



	public int getOrderID() {
		return orderID;
	}



	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void showAllOrderItems() {
		for (OrderItem orderItem : orderItems) {
			System.out.println(orderItem.getItem().getName());
			System.out.println(orderItem.getItem().getPrice()+"  x  " + orderItem.getQuantity());
		}
	}


	
	public void addOrderItem(OrderItem item) {
		orderItems.add(item);
	}
	public void removeOrderItem(int id) {
		orderItems.remove(id);
	}
	public double getTotal() {
		double ans = 0;
		for (OrderItem orderItem : orderItems) {
			ans += orderItem.getTotalPrice();
		}
		return ans;
	}
}
