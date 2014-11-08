package control;

import entity.MenuItem;
import entity.Set;
import entity.AlaCarte;

import java.util.*;
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

public class MenuManager {
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
	
	public MenuManager(){
		menu = loadMenuItems();
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
	
	private ArrayList<MenuItem> loadMenuItems(){
		Object object = IOManager.read(FILE_PATH);
		if(object instanceof ArrayList<?> && ((ArrayList<?>) object).get(0) instanceof MenuItem){
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
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Choose which you want: \n 1.Add New Alacarte to Menu \n"
					+ "2. Add New Set to Menu\n 3. Delete MenuItem from the Menu\n 4.Update the Alacarte\n"
					+"5. Update the Set on the Menu\n 6. Show all MenuItems \n" );
			switch (sc.nextInt()){
			case 1 :
				System.out.println("The name of the new Alacarte:");
				String name = sc.next();
				System.out.println("The description of the new Alacarte:");
				String description = sc.next();
				System.out.println("The category of the new Alacarte: ");
				String category = sc.next();
				System.out.println("The price of the new Alacarte:");
				double price = sc.nextDouble();
				addAlaCartetoMenu(name,description,category,price);
				break;
			case 2 :
				System.out.println("The name of the new Set:");
				String setname = sc.next();
				System.out.println("The description of the new Set:");
				String setdescription = sc.next();
				System.out.println("The category of the new Set: ");
				String setcategory = sc.next();
				System.out.println("The discountrate of the new Set:");
				double setdiscountrate = sc.nextDouble();
				addSet(setname,setdescription,setcategory,setdiscountrate);
				break;
			case 3:
				System.out.print("The name of the menuItem to delete");
				deleteMenuItem(sc.next());
				break;
			case 4 :				     
				System.out.println("The ID of the Alacarte to update");
				int menuitemid = sc.nextInt();
				System.out.println("Choose which attribute to update: \n 1. name\n 2. description\n"
						+ "3.Category\n4.Price\n");
				switch(sc.nextInt()){
				case 1 : 
					
				     System.out.println("The new name of the Alacarte:");
				     String newname = sc.next();
				     menu.get(menuitemid-1).setName(newname);
				case 2 :
				     System.out.println("The new description of the Alacarte");
				     String newdescription = sc.next();
				     menu.get(menuitemid-1).setDescription(newdescription);
				case 3 :
				     System.out.println("The new category of the Alacarte: ");
				     String newcategory = sc.next();
				     menu.get(menuitemid-1).setCategory(newcategory);
					 
				case 4 :
					
				     System.out.println("The new price of the Alacarte: ");
				     double newprice = sc.nextDouble();
				     menu.get(menuitemid-1).setPrice(newprice);
			       }
				break;
			case 5 :
				System.out.println("The ID of the Set to update");
				int setid = sc.nextInt();
				System.out.println("Choose which attribute to update: \n 1. name\n 2. description\n"
						+ "3.Category\n4.Price\n5.Discountrate");
				switch(sc.nextInt()){
				case 1 : 
				    System.out.println("The new name of the Set:");
				    String setnewname = sc.next();
				    menu.get(setid-1).setName(setnewname);
				case 2 :				    
					System.out.println("The new description of the Set");
				    String setnewdescription = sc.next();
					menu.get(setid-1).setDescription(setnewdescription);
				case 3 :				    
					System.out.println("The new category of the Set: ");
				    String setnewcategory = sc.next();
					menu.get(setid-1).setCategory(setnewcategory);
				case 4 :
					System.out.println("The new price of the Set: ");
				    double setnewprice = sc.nextDouble();
					((Set) menu.get(setid-1)).setPrice(setnewprice);
				case 5 :
					System.out.println("The new discountrate of the Set: ");
					double newdiscountrate = sc.nextDouble();
					((Set)menu.get(setid-1)).setDiscountRate(newdiscountrate);

				}
				break;
			case 6: 
				showAllItem();
				break;
			 
			}
		}
	}
}
	
		


