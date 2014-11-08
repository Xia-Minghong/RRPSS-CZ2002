package boundary;

import control.*;
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
        MenuManager menuManager = new MenuManager("menu.dat");
        MenuBoundary menuBoundary = new MenuBoundary(menuManager);

        MemberManager memberManager = new MemberManager("members.dat");
        MemberBoundary memberBoundary = new MemberBoundary(memberManager);

        OrderManager orderManager = new OrderManager(menuManager, "orders.dat");
        OrderBoundary orderBoundary = new OrderBoundary(orderManager);

        InvoiceManager invoiceManager = new InvoiceManager(orderManager, null,  restaurant.getGST_RATE(), restaurant.getSERVICE_CHARGE_RATE(), "invoices.dat");
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
        menuManager.saveMenuItems();
        //save other lists
    }


    public void init() {
        restaurantManager.load();
        restaurant.setGST_RATE(0.1);
        restaurant.setSERVICE_CHARGE_RATE(0.1);
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
