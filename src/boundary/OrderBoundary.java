package boundary;

import control.OrderManager;
import entity.Order;
import entity.OrderItem;

import java.util.Scanner;

public class OrderBoundary implements Runnable{
	
	public OrderManager manager;
	
	public OrderBoundary(OrderManager manager) {
		// TODO Auto-generated constructor stub
		this.manager = manager;
	}
	
	@Override
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
				System.out.println(manager.getOrderCollection().get(sc.nextInt()).getTotal());
				break;
			case 3:
				showAllOrderWithID();
				System.out.println("choose a order you want to remove");
				manager.getOrderCollection().remove(sc.nextInt());
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
				manager.getMenuManager().showAllItem();
				System.out.println("choose a item by inputting item ID");
				int item = sc.nextInt();
				System.out.println("How many "+ manager.getMenuManager().getMenuItemByld(item).getName() + " do you want?");
				int quantity = sc.nextInt();
				manager.getOrderCollection().get(orderID).addOrderItem(new
                        OrderItem(quantity, manager.getMenuManager().getMenuItemByld(item)));
				System.out.println("successfully ordered!");
				break;
			case 2:
				manager.getOrderCollection().get(orderID).showAllOrderItems();
				System.out.println("Choose a item you want to removed");
				manager.getOrderCollection().get(orderID).removeOrderItem(sc.nextInt());
				System.out.println("Removed!");
				break;
			default:
				return;
			}
		}
	}
	public void showAllOrderWithID() {
		for (Order order : manager.getOrderCollection()) {
			System.out.format("ID = %d \t staff No = %d \t table No = \t",order.getOrderID(),order.getStaffID(),order.getTableID());
		}
	}
	public void createOrder() {
		System.out.println("Input entity.Staff No & entity.Table No sperate by whitespace");
		Scanner scanner = new Scanner(System.in);
		manager.getOrderCollection().add(new Order(scanner.nextInt(), scanner.nextInt()));
		System.out.format("entity.Order with ID = %d was created", manager.getOrderCollection().get( manager.getOrderCollection().size()-1).getOrderID());
	}
	
}
