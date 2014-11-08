package control;

import entity.MenuItem;
import entity.Set;
import entity.AlaCarte;

import java.util.*;

/**
 * A manager which takes the responsibilities of :
 * 1. getting/writing menuItems data from/to file
 * 2. provide the methods to create, delete, update and show menuItems
 * @author Cao Gaoxu
 * @version 1.0
 * @since 2014-11-6
 * 
 */

public class MenuManager extends PersistentManager{

    /**
	 * The list of MenuItems
	 */
	private ArrayList<MenuItem> menu;
	
	
//	/**
//	 * the file path from which the menuItem list is read and
//	 * to which the menuItems list is written
//	 */
//	private final String FILE_PATH;
	
	/**
	 * constructor of Menu
	 * during the construction, menuItems are read from file and 
	 * the menuItem list in initialized
	 */
	
	public MenuManager(String FILE_PATH){
        super(FILE_PATH);
		menu = load();
	}
	  /**
	   * Create a new menuItem and add it into the menuItem list
	   * @param name, the name of new menuItem
	   * @param description, the words used to describe the new menuItem
	   * @param category, the category of the new menuItem
	   * @param price, the price of the new menuItem
	   */
	public void addAlaCartetoMenu(String name,String description, String category, double price){
		MenuItem menuitem = new AlaCarte(name, description,category, price);
		menu.add(menuitem);
	}
	
	/**
	 * 
	 * @param name
	 * @param description
	 * @param category
	 * @param discountrate
	 */
	public void addSet(String name, String description, String category, double discountrate){
		MenuItem menuitem = new Set(name, description, category, discountrate);
		menu.add(menuitem);
	}
	
	/**
	 * Delete the menuItem with the input name
	 * @param name, the name of the menuItem to be deleted
	 */
	public void deleteMenuItem(String name){
		int index = -1;
		
		for (MenuItem menuitem : menu){
			if (menuitem.getName().equals(name)){
				index = menu.indexOf(menuitem);
				break;
			}
		}
		
		if(index != -1){
			menu.remove(index);
		} 
	}
	
	/**
	 * Update menuItem's details
	 * @param menuItemID, the id of the menuItem to be updated
	 * @param name, the updated name of the menuItem.
	 * @param description, the description that is needed to be updated
	 * @param category
	 */
	
	//public void updateAlacarte(int menuItemID,String name,String description, String category,double price){
		//menu.get(menuItemID-1).setName(name);
	    //menu.get(menuItemID-1).setDescription(description);
		//menu.get(menuItemID-1).setCategory(category);
		//menu.get(menuItemID-1).setPrice(price);
	//} 
	
	public void updateSet(int menuItemID, String name,String description, String category, double discountrate){ 
		menu.get(menuItemID-1).setName(name);
		menu.get(menuItemID-1).setDescription(description);
		menu.get(menuItemID-1).setCategory(category);
		((Set) menu.get(menuItemID-1)).setDiscountRate(discountrate);
		
    }
	
	/**
	 * Get the menuItemId with the given name
	 * @param name, the name of the menuItem
	 * @return the menuIten id which is an integer
	 */

	public int getMenuItemId(String name){
		for (MenuItem menuitem: menu){
			if(menuitem.getName().equals(name)){
				return (menu.indexOf(menuitem)+1);
			}
		}
		return -1;
	}
	
	/**
	 * Get the menuItem with menuItemID given
	 * @param itemid, the id of the menuItem
	 * @return the menuItem with the id given
	 */
	public MenuItem getMenuItemByld(int itemid){
		if(menu.get(itemid-1) != null){
			return menu.get(itemid-1);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Show all the menuItems in the menu with their attributes.
	 */

	public void showAllItem(){
		for (MenuItem menuitem : menu){
		    System.out.println((menu.indexOf(menuitem)+1) + "   " +menuitem.getName() +"     "+ menuitem.getCategory() +"      "+ menuitem.getDescription() +
		    		            "      "+ menuitem.getPrice());
		}
	}
	
	/**
	 * Load menuItems data from file by interacting with IOManager
	 * @return a list of menuItems if success, null if fail
	 */
	
	private ArrayList<MenuItem> load(){
		Object object = read();
		if(object instanceof ArrayList<?> && ((ArrayList<?>) object).get(0) instanceof MenuItem){
			return (ArrayList<MenuItem>) object;
		}
		System.out.println("Error loading menuItems from file");
		return null;
		
	}
	
	/**
	 * Save the munuItem list into file
	 */
	public void save(){
		if( !write(menu)){
			System.out.println("Error saving menuItems to file!");
		}
	}

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }
}
	
		


