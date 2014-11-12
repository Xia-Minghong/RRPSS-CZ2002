package entity;

import java.io.Serializable;

/**
 * The entity class for restaurant
 *
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-11-6
 */
public class Restaurant implements Serializable{

    /**
     * GST rate of the restaurant, -1 indicating uninitialized.
     */
    private double GSTRate = -1;

    /**
     * The service charge rate of the restaurant, -1 indicating uninitialized.
     */
    private double serviceChargeRate = -1;

    /**
     * Name of the restaurant, blank indicating uninitialized.
     */
    private String restaurantName = "";

    /**
     * GST Rate of the restaurant, -1 indicating uninitialized.
     */
    private double membershipDiscountRate = -1;

    /**
     * Get the GST rate of the restaurant
     * @return the GST rate of the restaurant
     */
    public double getGSTRate() {
        return GSTRate;
    }

    /**
     * Set the GST rate of the restaurant
     * @param GSTRate the GST rate to set
     */
    public void setGSTRate(double GSTRate) {
        this.GSTRate = GSTRate;
    }

    /**
     * Get the service charge rate of the restaurant
     * @return the service charge rate of the restaurant
     */
    public double getServiceChargeRate() {
        return serviceChargeRate;
    }

    /**
     * Set the service charge rate of the restaurant.
     * @param serviceChargeRate the service charge rate of the restaurant.
     */
    public void setServiceChargeRate(double serviceChargeRate) {
        this.serviceChargeRate = serviceChargeRate;
    }

    /**
     * Get the name of the restaurant.
     * @return the name of the restaurant
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Set the name of the restaurant.
     * @param restaurantName the name of the restaurant.
     */
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /**
     * Get the membership discount rate of the restaurant.
     * @return the membership discount rate of the restaurant
     */
    public double getMembershipDiscountRate() {
        return membershipDiscountRate;
    }

    /**
     * Set the membership discount rate of the restaurant.
     * @param membershipDiscountRate the membership discount rate of the restaurant.
     */
    public void setMembershipDiscountRate(double membershipDiscountRate) {
        this.membershipDiscountRate = membershipDiscountRate;
    }
}
