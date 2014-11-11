package control;

import entity.AlaCarte;
import entity.MenuItem;
import entity.Set;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A MenuManager which takes the responsibilities of :
 * 1. getting/writing menuItems data from/to file
 * 2. provide the methods to create, delete, update and show menuItems
 * @author Cao Gaoxu
 * @version 1.0
 * @since 2014-11-6
 * 
 */

public class MenuManager extends AbstractManager {

    /**
	 * The list of MenuItems
	 */
	private ArrayList<MenuItem> menu;
	
	
	
	/**
	 * constructor of MenuMananger
	 * during the construction, MenuManager are read from file and 
	 * the menuItem list in initialized
	 * @param FILE_PATH, the file path from which the menuItem list is readand 
	 * to which the list is written
	 */
	
	public MenuManager(String FILE_PATH){
        super(FILE_PATH);
		menu = load();
	}
	
	  /**
	   * Create a new Ala Carte and add it into the menuItem list
	   * @param name, the name of new Ala Carte
	   * @param description, the words used to describe the new Ala Carte
	   * @param category, the category of the new Ala Carte
	   * @param price, the price of the new Ala Carte
	   */
	public void addAlaCartetoMenu(String name,String description, String category, double price){
		for(MenuItem item: menu){
			if (item.getName().equals(name)){
				System.out.println("This Ala Carte exists!");
				return;
			}
         }
		 MenuItem menuitem = new AlaCarte(name, description,category, price);
		 menu.add(menuitem);
		 System.out.println("New Ala Carte added");
	}
	
	/**
	 * Create a new set and add it to the menuItem list
	 * @param name, the name of the new Set
	 * @param description, the words used to describe the new set.
	 * @param category, the category or the new set.
	 * @param price, the price of the new set.
	 * @return the the new set itself.
	 */

	public Set addSettoMenu(String name, String description, String category, double price){
		Scanner sc = new Scanner(System.in);
		for(MenuItem item: menu){
			if (item.getName().equals(name)){
				System.out.println("This Set exists!");
				return null;
			}
         }
		MenuItem menuitem = new Set(name, description, category, price);
		menu.add(menuitem);
		return (Set) menuitem;
		
	}
	
	/**
	 * Delete the MenuItem from the menuItem list by its ID
	 * @param itemID, the ID of the menuItem to delete
	 */
	public void deleteMenuItembyID(int itemID){
		
		if(itemID > this.menu.size()){
			System.out.println("This menu item does not exist!");
		} 
		else{
			menu.remove(itemID-1);
		}
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
	 * Format the menuItem in order and
	 * Show all the menuItems in the menu with their attributes.
	 */
	public String menuToString(){
		StringBuffer ans = new StringBuffer();
		ans.append("===========Menu===========\n");
		for(MenuItem menuitem: menu){
			ans.append("*****************************\n"+"ID\t"+(this.getMenu().indexOf(menuitem)+1) + "\n"+menuitem+"\n");
		}
		ans.append("===========End=============\n");
		return ans.toString();

	}
	
	/**
	 * Load menuItems data from file by interacting with IOManager
	 * @return a list of menuItems if success, null if fail
	 */

    @Override
	public ArrayList<MenuItem> load(){
        ArrayList<MenuItem> menuItems = (ArrayList<MenuItem>) read();
        if (menuItems == null) {
            menuItems = new ArrayList<MenuItem>();
        }
        return menuItems;
		
	}
	
	/**
	 * Save the munuItem list into file
	 * print the error message when error occur
	 */
	public void save(){
		if( !write(menu)){
			System.out.println("Error saving menuItems to file!");
		}
	}
	
	/**
	 * Getter method to get menu
	 * @return menu
	 */
    public ArrayList<MenuItem> getMenu() {
        return menu;
    }
}
	
		


