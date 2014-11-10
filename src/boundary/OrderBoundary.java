package boundary;

import control.OrderManager;
import entity.Order;
import entity.OrderItem;

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
			System.out.println("\n 1. Create entity.Order \n 2.get total price of a order ");
			System.out.println(" 3. remove a order \n 4. view all orders \n 5. edit a order\n6. exit");
			System.out.println("Choose what you want");
			switch (sc.nextInt()) {
			case 1:	
				createOrder();
				break;
			case 2:
				showAllOrderWithID();
				System.out.println("choose a order you want to view");
				System.out.println(orderManager.getOrderCollection().get(sc.nextInt()).getTotal());
				break;
			case 3:
				showAllOrderWithID();
				System.out.println("choose a order you want to remove");
				orderManager.getOrderCollection().remove(sc.nextInt());
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
			System.out.println("1. add item\n2.removed item\n3.exit");
			switch (sc.nextInt()) {
			case 1:	
				orderManager.getMenuManager().showAllItem();
				System.out.println("choose a item by inputting item ID");
				int item = sc.nextInt();
				System.out.println("How many "+ orderManager.getMenuManager().getMenuItemByld(item).getName() + " do you want?");
				int quantity = sc.nextInt();
				orderManager.getOrderCollection().get(orderID).addOrderItem(new
                        OrderItem(quantity, orderManager.getMenuManager().getMenuItemByld(item)));
				System.out.println("successfully ordered!");
				break;
			case 2:
				orderManager.getOrderCollection().get(orderID).showAllOrderItems();
				System.out.println("Choose a item you want to removed");
				orderManager.getOrderCollection().get(orderID).removeOrderItem(sc.nextInt());
				System.out.println("Removed!");
				break;
			default:
				return;
			}
		}
	}
	public void showAllOrderWithID() {
		for (Order order : orderManager.getOrderCollection()) {
			System.out.format("ID = %d \t staff No = %d \t table No = \t",order.getOrderID(),order.getStaffID(),order.getTableID());
		}
	}
	public void createOrder() {
		System.out.println("Input entity.Staff No & entity.Table No sperate by whitespace");
		Scanner scanner = new Scanner(System.in);
		orderManager.getOrderCollection().add(new Order(scanner.nextInt(), scanner.nextInt()));
		System.out.format("Order with ID = %d was created ", orderManager.getOrderCollection().get( orderManager.getOrderCollection().size()-1).getOrderID());
	}
	
}
