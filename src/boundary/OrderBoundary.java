package boundary;

import control.OrderManager;
import entity.MenuItem;
import entity.Order;
import entity.OrderItem;
import entity.Staff;

import java.util.InputMismatchException;
import java.util.Scanner;

import sun.print.resources.serviceui;

public class OrderBoundary implements Runnable{
	
	public OrderManager orderManager;
	
	public OrderBoundary(OrderManager orderManager) {
		// TODO Auto-generated constructor stub
		this.orderManager = orderManager;
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			System.out.println("\n 1. Create Order \n 2. Get total price of a order ");
			System.out.println(" 3. Remove a order \n 4. View all orders \n 5. Edit a order\n any other input to exit");
			System.out.println("Choose what you want: ");			
			switch (secureNextInt(sc)) {
			case 1:	
				editOrder(createOrder());
				break;
			case 2:
				orderManager.showAllOrderWithID();
				System.out.println("Choose a order id you want to view");
				System.out.println(secureGetOrder(orderManager,sc).getTotal());
				break;
			case 3:
				System.out.println("This functionality is deprecated");
				break;
				/*int id;
				orderManager.showAllOrderWithID();
				System.out.println("Choose a order you want to remove");
				orderManager.removeOrderByID(id = secureGetOrderID(orderManager, sc));
				System.out.println("Successfully removed id = "+id);
				break;
				*/
			case 4:
				orderManager.showAllOrderWithID();
				break;
			case 5:
				orderManager.showAllOrderWithID();
				System.out.println("Choose a order you want to edit");
				editOrder(secureGetOrderID(orderManager, sc));
				break;
			default:
				return;
			}
		}
	}
	
	public static int secureNextInt(Scanner sc) {
		int ans;
		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("Please input an interger!");
				sc.nextLine();
				//e.printStackTrace();
			}
		}
	}
	
	
	public static Order secureGetOrder(OrderManager manager,Scanner sc) {
		while (true) {
			try {
				return manager.getOrderbyID(secureNextInt(sc));
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("Invalid Index please input again");
				System.out.println(888);//debug
			}
		}
	}
	
	public static int secureGetOrderID(OrderManager manager,Scanner sc) {
		int id;
		while (true) {
			try {
				Order a = manager.getOrderbyID(id = secureNextInt(sc));
				return id;
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("Invalid Index please input again");
				//System.out.println(8);//debug
			}
		}
	}
	
	public static int secureRangeInt(Scanner sc,int a,int b) {
		int ans=secureNextInt(sc);
		while (ans>b || ans<a) {
			System.out.println("Invalid try again!");//debug
			ans = secureNextInt(sc);
		} 
		return ans;
	}
	
	private void editOrder(int orderID) {
		Scanner sc = new Scanner(System.in);
		
		orderManager.getOrderbyID(orderID).showAllOrderItems();
		while (true) {
			System.out.println(" 1.add item\n 2.removed item\n 3.show all item\n 4.exit");
			System.out.println("choose what you want to do with the order");
			switch (secureNextInt(sc)) {
			case 1:	
				System.out.println(orderManager.getMenuManager().menuToString());
				System.out.println("choose a item by inputting item ID");
				//System.out.println(orderManager.getMenuManager().getMenu().size());
				int item = secureRangeInt(sc, 1, orderManager.getMenuManager().getMenu().size());

				System.out.println("How many "+ orderManager.getMenuManager().getMenuItemByld(item).getName() + " do you want?");
				int quantity = secureNextInt(sc);
				orderManager.getOrderbyID(orderID).addOrderItem(new
                        OrderItem(quantity, orderManager.getMenuManager().getMenuItemByld(item)));
				System.out.println("successfully ordered!");
				break;
			case 2:
				orderManager.getOrderbyID(orderID).showAllOrderItems();
				System.out.println("Choose a item you want to removed");
				orderManager.getOrderbyID(orderID).removeOrderItem(secureRangeInt(sc, 1, orderManager.getOrderbyID(orderID).getOrderItems().size()));
				System.out.println("Removed!");
				break;
			case 3:
				orderManager.getOrderbyID(orderID).showAllOrderItems();
				break;
			default:
				return;
			}
		}
	}
	
	public int createOrder() {
		Scanner sc = new Scanner(System.in);
		Staff aStaff;
		System.out.println("Input Staff No");
		while (true) {
			aStaff = orderManager.getStaffManager().getStaffbyID(secureNextInt(sc));
			if (aStaff != null) {
				break;
			}
			System.out.println("Invalid StaffNo, try again");
		}
		
		
		System.out.println("Input Table No");
		int tableNo = secureRangeInt(sc, 0, orderManager.getTableManager().getTables().size()-1);
		
		orderManager.getOrderCollection().add(new Order(aStaff,tableNo));
		System.out.format("Order with ID = %d was created \n", orderManager.getTotalNumberOfOrder());
		return orderManager.getTotalNumberOfOrder();
	}
	
}
