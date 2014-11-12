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
	
	
	private int tableID,orderSerial;
	private Staff staff;
	private static int orderCounter = 0;
	private ArrayList<OrderItem> orderItems;
	
	/**
	 * constructor 
	 * @param staff the staff who created this order
	 * @param tableID the table that this order belongs to 
	 */
	public Order(Staff staff, int tableID) {
		orderCounter ++;
		orderSerial = orderCounter;
		this.staff = staff;
		this.tableID = tableID;
		orderItems = new ArrayList<OrderItem>();
	}



	/**
	 * find who created this order
	 * @return a stff instance who created this order
	 */
	public Staff getStaff() {
		return staff;
	}

	/**
	 * get orderSerialNumber
	 * number will only increase and will not be reused
	 * @return the serial number
	 * @deprecated 
	 */
	public int getOrderID() {
		return orderSerial;
	}
	
	/**
	 * get the table of this order
	 * @return the table ID
	 */
	public int getTableID() {
		return tableID;
	}



	/**
	 * get the collection that holds the order items
	 * @return the collection, as arraylist
	 */
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	/**
	 * display all the order items
	 */
	public void showAllOrderItems() {
		System.out.println("------------------------------------------------");
		System.out.println("ItemID\t\tQuantity\tName\t\tTotalPrice");
		for (int i = 0; i < orderItems.size(); i++) {
			System.out.println((i+1)+"\t\t"+orderItems.get(i).toString());
			
		}
		System.out.println("------------------------------------------------");
	}

	/**
	 * adds a particular order item to the order
	 * @param item the order item to be added
	 */
	public void addOrderItem(OrderItem item) {
		orderItems.add(item);
	}
	
	/**
	 * delete an order item according to the id
	 * id ranges from 1 to n 
	 * @param id the id of which being removed
	 */
	public void removeOrderItem(int id) {
		orderItems.remove(id-1);
	}
	
	/**
	 * get total price of the whole order
	 * @return the total price
	 */
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
