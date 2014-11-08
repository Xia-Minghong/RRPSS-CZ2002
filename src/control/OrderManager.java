package control;

import entity.Order;
import entity.OrderItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class OrderManager implements Serializable{
	private static final double TAXRATE = 0.4;
	private static ArrayList<Order> orderCollection = new ArrayList<Order>();
	private MenuManager menuManager;
	public OrderManager(MenuManager menuManager) {
		// TODO Auto-generated constructor stub
		this.menuManager = menuManager;
	}
	public static ArrayList<Order> getOrderCollection() {
		return orderCollection;
	}
	public Order getOrderbyID(int id) {
		return orderCollection. get(id);
	}
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			System.out.println("choose what you want \n 1. Create entity.Order \n 2.get total price of a order ");
			System.out.println(" 3. remove a order \n 4. view all orders \n 5. edit a order 6. exit");
			
			switch (sc.nextInt()) {
			case 1:	
				createOrder();
				break;
			case 2:
				showAllOrderWithID();
				System.out.println("choose a order you want to view");
				System.out.println(orderCollection.get(sc.nextInt()).getTotal());
				break;
			case 3:
				showAllOrderWithID();
				System.out.println("choose a order you want to remove");
				orderCollection.remove(sc.nextInt());
				System.out.println("successfully removed");
				break;
			case 4:
				showAllOrderWithID();
				break;
			case 5:
				showAllOrderWithID();
				System.out.println("choose a order you want to edit");
				editOrder(sc.nextInt());
				break;
			default:
				return;
			}
		}
	}
	private void editOrder(int orderID) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("choose what you want to do with the order");
			System.out.println("1. add item\n2.removed item3.exit");
			switch (sc.nextInt()) {
			case 1:	
				menuManager.showAllItem();
				System.out.println("choose a item by inputting item ID");
				int item = sc.nextInt();
				System.out.println("How many "+ menuManager.getMenuItemByld(item).getName() + " do you want?");
				int quantity = sc.nextInt();
				orderCollection.get(orderID).addOrderItem(new
                        OrderItem(quantity, menuManager.getMenuItemByld(item)));
				System.out.println("successfully ordered!");
				break;
			case 2:
				orderCollection.get(orderID).showAllOrderItems();
				System.out.println("Choose a item you want to removed");
				orderCollection.get(orderID).removeOrderItem(sc.nextInt());
				System.out.println("Removed!");
				break;
			default:
				return;
			}
		}
	}
	public void showAllOrderWithID() {
		for (Order order : orderCollection) {
			System.out.format("ID = %d \t staff No = %d \t table No = \t",order.getOrderID(),order.getStaffID(),order.getTableID());
		}
	}
	public void createOrder() {
		System.out.println("Input entity.Staff No & entity.Table No sperate by whitespace");
		Scanner scanner = new Scanner(System.in);
		orderCollection.add(new Order(scanner.nextInt(), scanner.nextInt()));
		System.out.format("entity.Order with ID = %d was created", orderCollection.get(orderCollection.size()-1).getOrderID());
	}
	
}
