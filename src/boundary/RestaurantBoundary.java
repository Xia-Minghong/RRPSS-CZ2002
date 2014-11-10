package boundary;

import control.*;
import entity.Staff;
import entity.Table;

import java.util.Scanner;

/**
 * Boundary class for Restaurant Created by root on 14-11-7.
 */
public class RestaurantBoundary implements Runnable {
	RestaurantManager restaurantManager;

	public RestaurantBoundary() {
		this.restaurantManager = new RestaurantManager("restaurant.dat");
		init();
	}

	private void showMainMenu() {

		TableManager tableManager = new TableManager("tables.dat");
		TableBoundary tableBoundary = new TableBoundary(tableManager);

		StaffManager staffManager = new StaffManager("staffs.dat");
		StaffBoundary staffBoundary = new StaffBoundary(staffManager);

		MenuManager menuManager = new MenuManager("menu.dat");
		MenuBoundary menuBoundary = new MenuBoundary(menuManager);

		MemberManager memberManager = new MemberManager("members.dat");
		MemberBoundary memberBoundary = new MemberBoundary(memberManager);

		ReservationManager reservationManager = new ReservationManager(null,
				"reservations.dat");
		ReservationBoundary reservationBoundary = new ReservationBoundary(
				reservationManager);

		OrderManager orderManager = new OrderManager(menuManager, "orders.dat");
		OrderBoundary orderBoundary = new OrderBoundary(orderManager);

		InvoiceManager invoiceManager = new InvoiceManager(orderManager,
				staffManager, restaurantManager, "invoices.dat");
		InvoiceBoundary invoiceBoundary = new InvoiceBoundary(invoiceManager);

		// print main menu

		// while true
//		tableBoundary.run();
//		staffBoundary.run();

		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				menuBoundary.run();
				break;
			case 2:
				memberBoundary.run();
				break;
			case 3:
				reservationBoundary.run();
				break;
			case 4:
				orderBoundary.run();
				break;
			case 5:
				invoiceBoundary.run();
				break;
			case 6:
				menuManager.save();
				memberManager.save();
				reservationManager.save();
				orderManager.save();
				invoiceManager.save();
				restaurantManager.save();
				System.out.println("Bye");
				break;
			default:
				break;
			}
		} while (choice != 6);
		// If the user chooses to perform action about menu

		// If the user chooses to perform action about member

		// quit

		// save other managers
	}

	private void init() {
		Scanner scanner = new Scanner(System.in);

		// If GST Rate is not set
		if (restaurantManager.getRestaurant().getGST_RATE() < 0) {
			System.out.print("GST Rate: ");
			restaurantManager.getRestaurant().setGST_RATE(scanner.nextDouble());
		}

		// If Service Charge Rate is not set
		if (restaurantManager.getRestaurant().getSERVICE_CHARGE_RATE() < 0) {
			System.out.print("Service Charge Rate: ");
			restaurantManager.getRestaurant().setSERVICE_CHARGE_RATE(
					scanner.nextDouble());
		}

		// restaurantManager.load();
		// restaurant.setGST_RATE(0.1);
		// restaurant.setSERVICE_CHARGE_RATE(0.1);
		// //If restaurant does not have table or staffs
		// if (restaurant.getTables().size() == 0 ||
		// restaurant.getStaffs().size() == 0) {
		// ArrayList<Table> tables = new ArrayList<Table>();
		// //Prompt for input and add tables
		// System.out.println("entity.Table:");
		// restaurant.setTables(tables);
		// //set staffs
		// //set file paths
		// }
	}

	@Override
	public void run() {
		showMainMenu();
	}

	private void printMenu() {
		System.out.println("1. Menu management");
		System.out.println("2. Member management");
		System.out.println("3. Reservation management");
		System.out.println("4. Order management");
		System.out.println("5. Invoice management");
		System.out.println("6. Quit");
		System.out.print("You may wish to choose any options above:");
	}
}
