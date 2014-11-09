package control;

import entity.Restaurant;

import java.util.ArrayList;

/**
 * Created by root on 14-11-7.
 */
public class RestaurantManager extends AbstractManager {

    ArrayList<Restaurant> restaurants;

    public RestaurantManager(String FILE_PATH) {
        super(FILE_PATH);

        this.restaurants = load();
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public ArrayList load() {
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) read();
        if (restaurants == null) {
            restaurants = new ArrayList<Restaurant>();
        }
        return restaurants;
    }

    @Override
    public void save() {
        write(restaurants);
    }
}
