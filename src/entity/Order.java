package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author zhou
 *
 */
public class Order implements Serializable{
	/**
	 * VersionUID
	 */
	private static final long serialVersionUID = 8178299784454335281L;
	/**
	 * 
	 */
	private int tableID;
	private Staff staff;
	private ArrayList<OrderItem> orderItems;
	
	
	public Order(Staff staff, int tableID) {
		this.staff = staff;
		this.tableID = tableID;
		orderItems = new ArrayList<OrderItem>();
	}




	public Staff getStaff() {
		return staff;
	}



	public int getTableID() {
		return tableID;
	}




	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void showAllOrderItems() {
		System.out.println("==================================");
		System.out.println("ID\tQuantity\tName\tTotalPrice");
		for (int i = 0; i < orderItems.size(); i++) {
			System.out.println((i+1)+"\t"+orderItems.get(i).toString());
			
		}
		System.out.println("==================================");
	}

	
	public void addOrderItem(OrderItem item) {
		orderItems.add(item);
	}
	
	public void removeOrderItem(int id) {
		orderItems.remove(id-1);
	}
	
	public double getTotal() {
		double ans = 0;
		for (OrderItem orderItem : orderItems) {
			ans += orderItem.getTotalPrice();
		}
		return ans;
	}
	
	@Override
	public String toString() {
		StringBuffer ans = new StringBuffer();
		for (OrderItem orderItem : orderItems) {
			ans.append(orderItem.toString()+'\n');
		}
		return ans.toString();
	}
}
