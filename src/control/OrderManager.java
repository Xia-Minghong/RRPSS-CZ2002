package control;

import entity.Order;

import java.util.ArrayList;


public class OrderManager extends AbstractManager {
	private static final double TAXRATE = 0.4;
	private ArrayList<Order> orderCollection;
	private MenuManager menuManager;
	
	public OrderManager(MenuManager menuManager, String FILE_PATH) {
        super(FILE_PATH);
		this.orderCollection = load();
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
    public ArrayList load() {
        ArrayList<Order> orders = (ArrayList<Order>) read();
        if (orders == null) {
            orders = new ArrayList<Order>();
        }
        return orders;
    }

    @Override
	public void save() {
		write(orderCollection);
	}
}
