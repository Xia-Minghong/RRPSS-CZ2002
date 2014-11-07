
import java.awt.MenuItem;
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

public class Menu {
	/**
	 * The list of MenuItems
	 */
	private ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	
	/**
	 * the file path from which the menuItem list is read and 
	 * to which the menuItems list is written
	 */
	private static final String FILE_PATH = "menuItems.dat";
	
	/**
	 * constructor of Menu
	 * during the construction, menuItems are read from file and 
	 * the menuItem list in initialized
	 */
	
	public Menu(){
		menu = loadMenuItems();
	}
	  /**
	   * Create a new menuItem and add it into the menuItem list
	   * @param name, the name of new menuItem
	   * @param description, the words used to describe the new menuItem
	   * @param category, the category of the new menuItem
	   * @param price, the price of the new menuItem
	   */
	public void addMenuItem(String name,String description, String category, double price){
		MenuItem menuitem = new AlaCarte(name, description,category,price);
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
	
	public void updateMenuItem(int menuItemID;String name,String description, String catrgory,double price){
		menu[menuItemID-1].setName(name);
		menu[menuItemID-1].setDescription(description);
		menu[menuItemID-1].setCategory(category);
		menu[menuItemID-1].setPrice(price);
	} 
	
	/**
	 * Get the menuItemId with the given name
	 * @param name, the name of the menuItem
	 * @return the menuIten id which is an interger
	 */

	public int getMenuItemId(String name){
		for (MenuItem menuitem: menu){
			if(menuitem.getName().equals(name)){
				return (menu.indexOf(menuitem)+1);
			}
		}
		return null;
	}
	
	/**
	 * Get the menuItem with menuItemID given
	 * @param itemid, the id of the menuItem
	 * @return the menuItem with the id given
	 */
	public MenuItem getMenuItemByld(int itemid){
		if(menu[itemid-1] != null){
			return menu[itemid-1];
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
		    		            "      "+ emnuitem.getPrice());
		}
	}
	
	/**
	 * Load menuItems data from file by interacting with IOManager
	 * @return a list of menuItems if success, null if fail
	 */
	
	private ArrayList<MenuItem> loadMenuItems(){
		Object object = IOManager.readf(FILE_PATH);
		if(object instanceof ArrayList<?> && (ArrayList<?>) ((ArrayList) object).get(0) instanceof MenuItem){
			return (ArrayList<MenuItem>) object;
			
		}
		System.out.println("Error loading menuItems from file");
		return null;
		
	}
	
	/**
	 * Save the munuItem list into file
	 */
	public void saveMenuItems(){
		if( !IOManager.write(menu, FILE_PATH)){
			System.out.println("Error saving menuItems to file!");
		}
	}
}