package control;

import entity.Order;

import java.io.Serializable;
import java.util.ArrayList;


public class OrderManager implements Serializable{
	private static final double TAXRATE = 0.4;
	private ArrayList<Order> orderCollection;
	private MenuManager menuManager;
	private final String FILE_PATH;
	
	public OrderManager(MenuManager menuManager, String FILE_PATH) {
		this.orderCollection = load();
		this.menuManager = menuManager;
		this.FILE_PATH = FILE_PATH;
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
		IOManager.write(orderCollection, FILE_PATH);
	}
	public ArrayList<Order> load()
	{
		return (ArrayList<Order>) IOManager.read(FILE_PATH);
	}
}
