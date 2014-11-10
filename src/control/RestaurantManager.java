package control;

import entity.Restaurant;

import java.util.ArrayList;

/**
 * The control class for restaurant related logic / use cases
 *
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-11-6
 */
public class RestaurantManager extends AbstractManager {

    /**
     * Hold the Restaurant instance to mimic the behavior of a database
     * Each query to this instance is equivalent to a query to a database
     */
    Restaurant restaurant;

    /**
     * Constructor of the RestaurantManager class
     * @param FILE_PATH the file path from/to which the serialized restaurant stream is read/stored
     */
    public RestaurantManager(String FILE_PATH) {
        super(FILE_PATH);

        this.restaurant = load();
    }

    /**
     * Get the restaurant instance.
     * @return the restaurant instance in the manager
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * Get the GST rate of the restaurant.
     * @return the GST rate of the restaurant
     */
    public double getGSTRate() {
        return this.restaurant.getGSTRate();
    }

    /**
     * Set the GST rate of the restaurant.
     * @param rate the GST rate of the restaurant.
     */
    public void setGSTRate(double rate) {
        this.restaurant.setGSTRate(rate);
    }

    /**
     * Get the service charge rate of the restaurant.
     * @return the service charge rate of the restaurant
     */
    public double getServiceChargeRate() {
        return this.restaurant.getServiceChargeRate();
    }

    /**
     * Set the service charge rate of the restaurant.
     * @param rate the service charge rate of the restaurant.
     */
    public void setServiceChargeRate(double rate) {
        this.restaurant.setServiceChargeRate(rate);
    }

    /**
     * Get the name of the restaurant.
     * @return the name of the restaurant
     */
    public String getRestaurantName() {
        return this.restaurant.getRestaurantName();
    }

    /**
     * Set the name of the restaurant.
     * @param name the name of the restaurant.
     */
    public void setRestaurantName(String name) {
        this.restaurant.setRestaurantName(name);
    }

    /**
     * Get the membership discount rate of the restaurant.
     * @return the membership discount rate of the restaurant
     */
    public double getMembershipDiscountRate() {
        return this.restaurant.getMembershipDiscountRate();
    }

    /**
     * Set the membership discount rate of the restaurant.
     * @param rate the membership discount rate of the restaurant.
     */
    public void setMembershipDiscountRate(double rate) {
        this.restaurant.setMembershipDiscountRate(rate);
    }

    /**
     * Customized method to read the restaurant instance from file
     * @return the restaurant read from file or a new restaurant instance if no one is read
     */
    @Override
    public Restaurant load() {
        Restaurant restaurant = (Restaurant) read();
        if (restaurant == null) {
            restaurant = new Restaurant();
        }
        return restaurant;
    }

    /**
     * Customized method to write the restaurant instance to file
     */
    @Override
    public void save() {
        write(restaurant);
    }
}
