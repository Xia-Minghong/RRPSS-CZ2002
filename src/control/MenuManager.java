package control;

import entity.AlaCarte;
import entity.MenuItem;
import entity.Set;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A orderManager which takes the responsibilities of :
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
	

	public void deleteMenuItembyID(int itemID){
		
		if(itemID > this.menu.size()){
			System.out.println("This menu item does not exist!");
		} 
		else{
			menu.remove(itemID-1);
		}
	}
	
	/**
	 * Update menuItem's details
	 * @param menuItemID, the id of the menuItem to be updated
	 * @param name, the updated name of the menuItem.
	 * @param description, the description that is needed to be updated
	 * @param category
	 */
	

	
	//public void updateSet(int menuItemID, String name,String description, String category, double discountrate){ 
		//menu.get(menuItemID-1).setName(name);
		//menu.get(menuItemID-1).setDescription(description);
		//menu.get(menuItemID-1).setCategory(category);
		//((Set) menu.get(menuItemID-1)).setDiscountRate(discountrate);
		
    //}
	
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

	//public void showAllItem(){
		//System.out.println("===========Menu===========");
		//for (MenuItem menuitem : menu){
			//System.out.println("***********************");
		    //System.out.println("ID"+(menu.indexOf(menuitem)+1) + "\n"+"Name:\t\t\t" +menuitem.getName() +"\n"+"Category:\t\t"+ menuitem.getCategory() +"\n"+"Description:\t"+ menuitem.getDescription() +
		    		            //"\n"+"Price:\t\t\t"+ menuitem.getPrice());
		//}
		///System.out.println("===========End=============");
	///}
	public String menuToString(){
		StringBuffer ans = new StringBuffer();
		ans.append("===========Menu===========\n");
		for(MenuItem menuitem: menu){
			ans.append("*****************************\n"+"ID\t"+(this.getMenu().indexOf(menuitem)+1) + "\n"+menuitem+"\n");
		}
		ans.append("===========End=============");
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
	
		


