package control;

import entity.Restaurant;

/**
 * Created by root on 14-11-7.
 */
public class RestaurantManager extends AbstractManager {

    Restaurant restaurant;

    public RestaurantManager(String FILE_PATH) {
        super(FILE_PATH);

        this.restaurant = (Restaurant) read();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public void save() {
        write(restaurant);
    }
}