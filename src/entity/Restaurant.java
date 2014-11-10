package entity;

import java.io.Serializable;

/**
 * Created by Xia-Minghong on 14-11-7.
 */
public class Restaurant implements Serializable{

    private double GSTRate = -1;
    private double serviceChargeRate = -1;
    private String restaurantName = "";
    private double membershipDiscountRate = -1;

    public double getGSTRate() {
        return GSTRate;
    }

    public void setGSTRate(double GSTRate) {
        this.GSTRate = GSTRate;
    }

    public double getServiceChargeRate() {
        return serviceChargeRate;
    }

    public void setServiceChargeRate(double serviceChargeRate) {
        this.serviceChargeRate = serviceChargeRate;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getMembershipDiscountRate() {
        return membershipDiscountRate;
    }

    public void setMembershipDiscountRate(double membershipDiscountRate) {
        this.membershipDiscountRate = membershipDiscountRate;
    }
}
