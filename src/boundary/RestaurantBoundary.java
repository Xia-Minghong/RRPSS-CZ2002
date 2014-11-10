package boundary;

import control.*;

import java.util.Scanner;

/**
 * @author <Collaborative Effort>
 * @version 1.0
 * @since 2014-11-6
 */
public class RestaurantBoundary implements Runnable {
	RestaurantManager restaurantManager;

	public RestaurantBoundary() {
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

//        staffBoundary.run();
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
            while (true) {
                try {
                    String input = sc.next();
                    choice = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException ne) {    //handle invalid input
                    System.out.print("Invalid choice, choose again: ");
                }
            }

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
                System.out.println("Saving system data");
                tableManager.save();
                staffManager.save();
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

        this.restaurantManager = new RestaurantManager("restaurant.dat");

		// If GST Rate is not set
		if (restaurantManager.getGSTRate() < 0) {
			System.out.print("GST Rate: ");
			restaurantManager.setGSTRate(scanner.nextDouble());
		}

		// If Service Charge Rate is not set
		if (restaurantManager.getServiceChargeRate() < 0) {
			System.out.print("Service Charge Rate: ");
			restaurantManager.setServiceChargeRate(
                    scanner.nextDouble());
		}

        if (restaurantManager.getRestaurantName() == "") {
            System.out.print("Restaurant Name: ");
            restaurantManager.setRestaurantName(
                    scanner.next());
        }

        if (restaurantManager.getMembershipDiscountRate() < 0) {
            System.out.print("Membership Discount Rate");
            restaurantManager.setMembershipDiscountRate(scanner.nextDouble());
        }

		// restaurantManager.load();
		// restaurant.setGSTRate(0.1);
		// restaurant.setServiceChargeRate(0.1);
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
