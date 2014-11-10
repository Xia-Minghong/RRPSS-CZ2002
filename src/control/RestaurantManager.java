package control;

import entity.Restaurant;

import java.util.ArrayList;

/**
 * Created by root on 14-11-7.
 */
public class RestaurantManager extends AbstractManager {

    Restaurant restaurant;

    public RestaurantManager(String FILE_PATH) {
        super(FILE_PATH);

        this.restaurant = load();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public double getGSTRate() {
        return this.restaurant.getGSTRate();
    }

    public void setGSTRate(double rate) {
        this.restaurant.setGSTRate(rate);
    }

    public double getServiceChargeRate() {
        return this.restaurant.getServiceChargeRate();
    }

    public void setServiceChargeRate(double rate) {
        this.restaurant.setServiceChargeRate(rate);
    }

    public String getRestaurantName() {
        return this.restaurant.getRestaurantName();
    }

    public void setRestaurantName(String name) {
        this.restaurant.setRestaurantName(name);
    }

    public double getMembershipDiscountRate() {
        return this.restaurant.getMembershipDiscountRate();
    }

    public void setMembershipDiscountRate(double rate) {
        this.restaurant.setMembershipDiscountRate(rate);
    }

    @Override
    public Restaurant load() {
        Restaurant restaurant = (Restaurant) read();
        if (restaurant == null) {
            restaurant = new Restaurant();
        }
        return restaurant;
    }

    @Override
    public void save() {
        write(restaurant);
    }
}
