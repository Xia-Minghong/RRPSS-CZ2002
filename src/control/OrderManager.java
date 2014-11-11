package control;

import entity.Order;

import java.util.ArrayList;


public class OrderManager extends AbstractManager {
	private ArrayList<Order> orderCollection;
	private MenuManager menuManager;
	private StaffManager staffManager;
	private TableManager tableManager;
	
	public OrderManager(MenuManager menuManager,StaffManager staffManager, String FILE_PATH) {
        super(FILE_PATH);
		this.orderCollection = load();
		this.menuManager = menuManager;
		this.staffManager = staffManager;
	}
	
	public OrderManager(MenuManager menuManager, StaffManager staffManager,
			TableManager tableManager,String FILE_PATH) {
		super(FILE_PATH);
		this.orderCollection = load();
		this.menuManager = menuManager;
		this.staffManager = staffManager;
		this.tableManager = tableManager;
	}

	public ArrayList<Order> getOrderCollection() {
		return orderCollection;
	}
	public TableManager getTableManager() {
		return tableManager;
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
		System.out.println("==================================");
		for (int i = 0; i < orderCollection.size(); i++) {
			System.out.format("ID = %d \t staff No = %d \t table No = %d \t\n",i+1,orderCollection.get(i).getStaff().getStaffID(),orderCollection.get(i).getTableID());			
		}
		System.out.println("==================================");
	}
	
	public void showAllOrderWithIDAndContent() {
		System.out.println("==================================");
		for (int i = 0; i < orderCollection.size(); i++) {
			System.out.format("ID = %d \t staff No = %d \t table No = \t",i+1,orderCollection.get(i).getStaff().getStaffID(),orderCollection.get(i).getTableID());
			orderCollection.get(i).showAllOrderItems();
		}
		System.out.println("==================================");
	}
	public int getTotalNumberOfOrder() {
		return orderCollection.size();
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
