package control;

import entity.Order;

import java.util.ArrayList;

/**
 * Manager Orders, holding an reference to an list of all the orders 
 * @author Zhou Jingyuan
 * @since 2014-11-11
 */
public class OrderManager extends AbstractManager {
	
	/**
	 * a collection of all the order in the restaurant 
	 */
	private ArrayList<Order> orderCollection;
	
	/**
	 * a reference to the menu manager for ordering 
	 */
	private MenuManager menuManager;
	
	/**
	 * a reference to the staff manager for verification
	 */
	private StaffManager staffManager;
	
	/**
	 * a reference to the table manager for verification
	 */
	private TableManager tableManager;
	
	/**
	 * constructor using fields
	 * @param menuManager an instance of menu Manager  
	 * @param staffManager an instance of a staff manager
	 * @param FILE_PATH the file path to store the serialized data
	 * @deprecated deprecated constructor
	 */
	public OrderManager(MenuManager menuManager,StaffManager staffManager, String FILE_PATH) {
        super(FILE_PATH);
		this.orderCollection = load();
		this.menuManager = menuManager;
		this.staffManager = staffManager;
	}
	
	/**
	 * constructor using fields
	 * @param menuManager an instance of menu Manager for menu display
	 * @param staffManager an instance of a staff manager verification
	 * @param tableManager an instance of a table manager for verification 
	 * @param FILE_PATH FILE_PATH the file path to store the serialized data
	 */
	public OrderManager(MenuManager menuManager, StaffManager staffManager,
			TableManager tableManager,String FILE_PATH) {
		super(FILE_PATH);
		this.orderCollection = load();
		this.menuManager = menuManager;
		this.staffManager = staffManager;
		this.tableManager = tableManager;
	}

	/**
	 * getter for order collection
	 * @return order collection that contains all the orders
	 */
	public ArrayList<Order> getOrderCollection() {
		return orderCollection;
	}
	
	/**
	 * getter
	 * @return the private Table manager 
	 */
	public TableManager getTableManager() {
		return tableManager;
	}
	public StaffManager getStaffManager() {
		return staffManager;
	}
	
	
	/**
	 * getter for order 
	 * @param id the id for a particular order
	 * @return the order, null if the id not exist
	 */
	public Order getOrderbyID(int id) {
		try {
			return orderCollection.get(id-1);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception

            return null;
        }
	}
	
	
	/**
	 * display all the orders in the following format
	 * ID = Staffno= tableno = 
	 */
	public void showAllOrderWithID() {
		System.out.println("=================================================");
		for (int i = 0; i < orderCollection.size(); i++) {
			System.out.format("Order ID = %d \t staff No = %d \t table No = %d \t\n",i+1,orderCollection.get(i).getStaff().getStaffID(),orderCollection.get(i).getTableID());			
		}
		System.out.println("=================================================");
	}
	
	
	/**
	 * display all the orders and their details
	 */
	public void showAllOrderWithIDAndContent() {

		for (int i = 0; i < orderCollection.size(); i++) {
			System.out.println("=================================================");
			System.out.format("Order ID = %d \t staff No = %d \t table No = %d \t\n",i+1,orderCollection.get(i).getStaff().getStaffID(),orderCollection.get(i).getTableID());
			orderCollection.get(i).showAllOrderItems();
			System.out.println("=================================================\n");
		}
		
	}
	/**
	 * getter, total number of orders
	 * @return total number of orders
	 */
	public int getTotalNumberOfOrder() {
		
		return orderCollection.size();
	}
	
	/**
	 * getter for menu manager 
	 * @return a menu manager
	 */
	public MenuManager getMenuManager() {
		return menuManager;
	}
	
	
	/**
	 * remove a particular order by ID
	 * @param arg0 the id of the order being removed
	 * @deprecated method should not be used to protect the integrity of invoice
	 */
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
