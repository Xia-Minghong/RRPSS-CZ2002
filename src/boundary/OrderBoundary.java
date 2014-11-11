package boundary;

import control.OrderManager;
import entity.MenuItem;
import entity.Order;
import entity.OrderItem;
import entity.Staff;

import java.util.Scanner;

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
			System.out.println("\n 1. Create Order \n 2.get total price of a order ");
			System.out.println(" 3. remove a order \n 4. view all orders \n 5. edit a order\n6. exit");
			System.out.println("Choose what you want: ");			
			switch (secureNextInt(sc)) {
			case 1:	
				editOrder(createOrder());
				break;
			case 2:
				orderManager.showAllOrderWithID();
				System.out.println("choose a order you want to view");
				System.out.println(secureGetOrder(orderManager,sc).getTotal());
				break;
			case 3:
				int id;
				orderManager.showAllOrderWithID();
				System.out.println("choose a order you want to remove");
				orderManager.removeOrderByID(id = secureGetOrderID(orderManager, sc));
				System.out.println("successfully removed id = "+id);
				break;
			case 4:
				orderManager.showAllOrderWithID();
				break;
			case 5:
				orderManager.showAllOrderWithID();
				System.out.println("choose a order you want to edit");
				editOrder(secureGetOrderID(orderManager, sc));
				break;
			default:
				return;
			}
		}
	}
	
	public static int secureNextInt(Scanner sc) {
		while (true) {
			try {
				return sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please input an interger!");
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
			}
		}
	}
	
	private void editOrder(int orderID) {
		Scanner sc = new Scanner(System.in);
		orderManager.getOrderCollection().get(orderID).showAllOrderItems();
		while (true) {
			System.out.println("1. add item\n2.removed item\n3.show all item\n4.exit");
			System.out.println("choose what you want to do with the order");
			switch (secureNextInt(sc)) {
			case 1:	
				orderManager.getMenuManager().menuToString();
				System.out.println("choose a item by inputting item ID");
				int item = secureNextInt(sc);
				System.out.println("How many "+ orderManager.getMenuManager().getMenuItemByld(item).getName() + " do you want?");
				int quantity = secureNextInt(sc);
				orderManager.getOrderCollection().get(orderID).addOrderItem(new
                        OrderItem(quantity, orderManager.getMenuManager().getMenuItemByld(item)));
				System.out.println("successfully ordered!");
				break;
			case 2:
				orderManager.getOrderCollection().get(orderID).showAllOrderItems();
				System.out.println("Choose a item you want to removed");
				orderManager.getOrderCollection().get(orderID).removeOrderItem(secureNextInt(sc));
				System.out.println("Removed!");
				break;
			case 3:
				orderManager.getOrderCollection().get(orderID).showAllOrderItems();
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
		int tableNo = secureNextInt(sc);
		
		orderManager.getOrderCollection().add(new Order(aStaff,tableNo));
		System.out.format("Order with ID = %d was created ", orderManager.getTotalNumberOfOrder());
		return orderManager.getTotalNumberOfOrder();
	}
	
}
