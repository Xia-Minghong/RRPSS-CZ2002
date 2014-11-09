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
