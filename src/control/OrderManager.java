package control;

import entity.Order;
import entity.OrderItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class OrderManager implements Serializable{
	private static final double TAXRATE = 0.4;
	private ArrayList<Order> orderCollection;
	private MenuManager menuManager;
	public OrderManager(MenuManager menuManager,ArrayList<Order> orderCollection) {
		// TODO Auto-generated constructor stub
		this.menuManager = menuManager;
		this.orderCollection = orderCollection;
	}
	public ArrayList<Order> getOrderCollection() {
		return orderCollection;
	}
	public Order getOrderbyID(int id) {
		return orderCollection. get(id);
	}
	public MenuManager getMenuManager() {
		return menuManager;
	}
	
}
