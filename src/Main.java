import boundary.RRPSS;
import control.RestaurantManager;
import entity.Restaurant;

/**
 * Created by root on 14-11-7.
 */
public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        RestaurantManager restaurantManager = new RestaurantManager(restaurant);
        RRPSS RRPSS = new RRPSS(restaurant, restaurantManager);
        RRPSS.run();
    }
}
