package boundary;

import control.InvoiceManager;
import control.MemberManager;
import control.OrderManager;
import control.RestaurantManager;
import entity.*;

import java.util.ArrayList;

/**
 * Created by root on 14-11-7.
 */
public class RRPSS {
    Restaurant restaurant;
    RestaurantManager restaurantManager;

    public RRPSS(Restaurant restaurant, RestaurantManager restaurantManager) {
        this.restaurant = restaurant;
        this.restaurantManager = restaurantManager;
    }

    public void showMainMenu() {

        ArrayList<Member> members = new ArrayList<Member>();
        MemberManager memberManager = new MemberManager(members, "members.dat");
        MemberBoundary memberBoundary = new MemberBoundary(members, memberManager);

        ArrayList<Order> orders = new ArrayList<Order>();
        OrderManager orderManager = new OrderManager(orders, "members.dat");
        OrderBoundary orderBoundary = new OrderBoundary(orders, orderManager);

        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        InvoiceManager invoiceManager = new InvoiceManager(invoices, "members.dat");
        InvoiceBoundary invoiceBoundary = new InvoiceBoundary(invoices, invoiceManager);

        //rest of managers

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
        memberManager.save();
//        menuManager.save();
        //save other lists
    }


    public void init() {
        restaurantManager.load();
        //If restaurant does not have table or staffs
        if (restaurant.getTables().size() == 0 || restaurant.getStaffs().size() == 0) {
            ArrayList<Table> tables = new ArrayList<Table>();
            //Prompt for input and add tables
            System.out.println("entity.Table:");
           restaurant.setTables(tables);
            //set staffs
            //set file paths
        }
    }

    public void run() {
        init();
        showMainMenu();
    }
}
