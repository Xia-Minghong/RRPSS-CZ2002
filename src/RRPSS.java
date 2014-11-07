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

        //rest of managers

        //print main menu

        //while true
        //let's say now we choose to perform action about member
        ArrayList<Member> members = new ArrayList<Member>();
        MemberManager memberManager = new MemberManager(members, "path");
        MemberBoundary memberBoundary = new MemberBoundary(members, memberManager);
        memberBoundary.run();
    }


    public void init() {
        restaurantManager.load();
        if (restaurant.getTables().size() == 0 || restaurant.getStaffs().size() == 0) {
            ArrayList<Table> tables = new ArrayList<Table>();
            //Prompt for input and add tables
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
