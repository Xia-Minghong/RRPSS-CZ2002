package boundary;

import control.*;

import java.util.Scanner;

/**
 * Boundary class for Restaurant
 * Created by root on 14-11-7.
 */
public class RRPSS implements Runnable{
    RestaurantManager restaurantManager;

    private void showMainMenu() {

        MenuManager menuManager = new MenuManager("menu.dat");
        MenuBoundary menuBoundary = new MenuBoundary(menuManager);

        MemberManager memberManager = new MemberManager("members.dat");
        MemberBoundary memberBoundary = new MemberBoundary(memberManager);

        ReservationManager reservationManager = new ReservationManager(null, "reservations.dat");
        ReservationBoundary reservationBoundary = new ReservationBoundary(reservationManager);

        OrderManager orderManager = new OrderManager(menuManager, "orders.dat");
        OrderBoundary orderBoundary = new OrderBoundary(orderManager);

        InvoiceManager invoiceManager = new InvoiceManager(orderManager, null, restaurantManager.getRestaurants().getGST_RATE(), restaurantManager.getRestaurants().getSERVICE_CHARGE_RATE(), "invoices.dat");
        InvoiceBoundary invoiceBoundary = new InvoiceBoundary(invoiceManager);


        //print main menu

        //while true
        //If the user chooses to perform action about member
        memberBoundary.run();


        orderBoundary.run();

        //If the user chooses to perform action about menu
//        ArrayList<entity.MenuItem> menuItems = new ArrayList<entity.MenuItem>();
//        control.Menu menu = new control.Menu(menuItems, "path");
//        MenuBoundary menuBoundary = new MenuBoundary(menuItems, memberManager);
//        memberBoundary.run();


        //quit
        menuManager.save();
        //save other lists
    }


    private void init() {
        Scanner scanner = new Scanner(System.in);
        this.restaurantManager = new RestaurantManager("restaurant.dat");

        //If GST Rate is not set
        if (restaurantManager.getRestaurants().getGST_RATE() < 0) {
            System.out.print("GST Rate: ");
            restaurantManager.getRestaurants().setGST_RATE(scanner.nextDouble());
        }

        //If Service Charge Rate is not set
        if (restaurantManager.getRestaurants().getSERVICE_CHARGE_RATE() < 0) {
            System.out.print("Service Charge Rate: ");
            restaurantManager.getRestaurants().setSERVICE_CHARGE_RATE(scanner.nextDouble());
        }

//        restaurantManager.load();
//        restaurant.setGST_RATE(0.1);
//        restaurant.setSERVICE_CHARGE_RATE(0.1);
//        //If restaurant does not have table or staffs
//        if (restaurant.getTables().size() == 0 || restaurant.getStaffs().size() == 0) {
//            ArrayList<Table> tables = new ArrayList<Table>();
//            //Prompt for input and add tables
//            System.out.println("entity.Table:");
//           restaurant.setTables(tables);
//            //set staffs
//            //set file paths
//        }
    }

    @Override
    public void run() {
        init();
        showMainMenu();
        restaurantManager.save();
    }
}
