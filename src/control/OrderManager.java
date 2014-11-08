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
	private String dataPath;
	
	public OrderManager(ArrayList<Order> orderCollection, MenuManager menuManager, String dataPath) {
		this.orderCollection = orderCollection;
		this.menuManager = menuManager;
		this.dataPath = dataPath;
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
	
	public void save() {
		IOManager.write(orderCollection, dataPath);
	}
	public void load()
	{
		orderCollection = (ArrayList<Order>) IOManager.read(dataPath);
	}
}
