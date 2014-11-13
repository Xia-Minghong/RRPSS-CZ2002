import boundary.RestaurantBoundary;

/**
 * Main entry point of the RRPSS application
 *
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-11-6
 */
public class RRPSSApp {
    public static void main(String[] args) {

        RestaurantBoundary RestaurantBoundary = new RestaurantBoundary();
        RestaurantBoundary.run();
    }
}
