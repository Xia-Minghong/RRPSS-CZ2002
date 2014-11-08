package control;

import entity.Order;

import java.io.Serializable;
import java.util.ArrayList;


public class OrderManager extends PersistentManager{
	private static final double TAXRATE = 0.4;
	private ArrayList<Order> orderCollection;
	private MenuManager menuManager;
	
	public OrderManager(MenuManager menuManager, String FILE_PATH) {
        super(FILE_PATH);
		this.orderCollection = (ArrayList<Order>) read();
		this.menuManager = menuManager;
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

    @Override
	public void save() {
		write(orderCollection);
	}
}
