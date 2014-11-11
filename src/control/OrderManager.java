package control;

import entity.Order;

import java.util.ArrayList;


public class OrderManager extends AbstractManager {
	private static final double TAXRATE = 0.4;
	private ArrayList<Order> orderCollection;
	private MenuManager menuManager;
	private StaffManager staffManager;
	
	public OrderManager(MenuManager menuManager,StaffManager staffManager, String FILE_PATH) {
        super(FILE_PATH);
		this.orderCollection = load();
		this.menuManager = menuManager;
		this.staffManager = staffManager;
	}
	
	public ArrayList<Order> getOrderCollection() {
		return orderCollection;
	}
	
	public StaffManager getStaffManager() {
		return staffManager;
	}
	/*
	 * 
	 */
	public Order getOrderbyID(int id) {
		return orderCollection.get(id-1);
	}
	
	public void showAllOrderWithID() {
		for (int i = 0; i < orderCollection.size(); i++) {
			System.out.format("ID = %d \t staff No = %d \t table No = \t",i+1,orderCollection.get(i).getStaff().getStaffID(),orderCollection.get(i).getTableID());			
		}
	}
	
	public void showAllOrderWithIDAndContent() {
		for (int i = 0; i < orderCollection.size(); i++) {
			System.out.format("ID = %d \t staff No = %d \t table No = \t",i+1,orderCollection.get(i).getStaff().getStaffID(),orderCollection.get(i).getTableID());
			orderCollection.get(i).showAllOrderItems();
		}
	}
	public int getTotalNumberOfOrder() {
		return orderCollection.size()+1;
	}
	
	public MenuManager getMenuManager() {
		return menuManager;
	}

	public void removeOrderByID(int arg0) {
		// TODO Auto-generated method stub
		orderCollection.remove(arg0-1);
	}
	
	
    @Override
    public ArrayList<Order> load() {
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
