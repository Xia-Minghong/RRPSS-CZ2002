import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class OrderManager implements Serializable{
	private static final double TAXRATE = 0.4;
	private static ArrayList<Order> orderCollection = new ArrayList<Order>();
	
	public static ArrayList<Order> getOrderCollection() {
		return orderCollection;
	}
	
	public void run() {
		int choice;
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			System.out.println("choose what you want \n 1. Create Order \n 2.get total price of a order ");
			System.out.println(" 3. remove a order \n 4. view all orders \n 5. edit a order 6. exit");
			choice = sc.nextInt();
			switch (choice) {
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
		System.out.println("Input Staff No & Table No sperate by whitespace");
		Scanner scanner = new Scanner(System.in);
		orderCollection.add(new Order(scanner.nextInt(), scanner.nextInt()));
		System.out.format("Order with ID = %d was created", orderCollection.get(orderCollection.size()-1).getOrderID());
	}
	
}
