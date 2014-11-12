package boundary;

import control.MenuManager;
import control.OrderManager;
import entity.AlaCarte;
import entity.MenuItem;
import entity.Order;
import entity.Set;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The boundary class handing user interaction related to Menu
 * 
 * @author Cao Gaoxu
 * @version1.0
 * Created by root on 14-11-8.
 */
public class MenuBoundary implements Runnable{
	
	/**
	 * The reference to a menu control instance
	 */
    private MenuManager menuManager;
    
    /**
     * Constructor of the restaurant boundary class
     * @param menuManager the instance of the MenuManager
     */
    public MenuBoundary(MenuManager menuManager) {
        this.menuManager = menuManager;
    }
    
    /**
     * Entry point of this boundary
     */
    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);
        ArrayList<MenuItem> menu = menuManager.getMenu();
        while(true){
            System.out.print("1. Add New Alacarte to Menu \n"
                    + "2. Add New Set to Menu\n3. Delete MenuItem from the Menu\n4. Update the Alacarte\n"
                    +"5. Update the Set on the Menu\n6. Show all MenuItems \n7. Back\nChoose which you want:" );
            int choice = inputInteger();
            switch (choice){
                case 1 :
                    System.out.print("The name of the new Alacarte:\t");
                    String name = sc.nextLine();
                    System.out.print("The description of the new Alacarte:\t");
                    String description = sc.nextLine();
                    System.out.print("The category of the new Alacarte:\t");
                    String category = sc.next();
                    System.out.print("The price of the new Alacarte:\t");
                    double price = inputDouble();
                    sc.nextLine();
                    menuManager.addAlaCartetoMenu(name, description, category, price);
                    break;
                case 2 :
                	createSet(menuManager);
                    break;
                case 3:
                	deleteMenuItem(menuManager);
                    break;
                case 4 :
                    updateAlacarte(menu);
                    break;
                case 5 :
                	updateSet(menu);
                    break;
                case 6:
                	System.out.println(menuManager.menuToString());
                    break;
                default:
                	return;

            }
        }
    }
    
    /**
     * Method to create the new set according to the user input
     * @param menuManager the instance of the MenuManager
     */
    public void createSet(MenuManager menuManager){
    	boolean bol = false;
    	Scanner sc = new Scanner(System.in);
        System.out.print("The name of the new Set:\t");
        String setname = sc.nextLine();
        System.out.print("The description of the new Set:\t");
        String setdescription = sc.nextLine();
        System.out.print("The category of the new Set:\t");
        String setcategory = sc.next();
        System.out.print("The price of the new Set:\t");
        double setprice = inputDouble();  
        Set newSet = menuManager.addSettoMenu(setname, setdescription, setcategory, setprice);
        if (newSet == null){
        	return;
        }
        else{
        	if(secureAlacarteExist(menuManager)){
        		do{
	        	System.out.println(menuManager.menuToString());
	        	System.out.print("Enter the Ala Carte ID to add into this Set:\t");
	        	int itemID = menuManager.getMenu().indexOf(secureGetMenuItem(menuManager));
	        	if((menuManager.getMenu().get(itemID)) instanceof Set){
	        		System.out.println("Cannot add a set into a set! ");
	        	}
	        	else{
	        		newSet.addAlaCartetoSet(menuManager.getMenu(), itemID);	 	             	
	             }
	        	System.out.print("Add one more Ala Carte? ('y' to Continue)");
	        	bol = sc.next().equals("y");
	        	sc.nextLine();
	            }while(bol);
        	 }
            else{
        		System.out.println("There is no Ala Carte in the menu!");
        	  }        		      	
        }
    }
    
	/**
	 * Method to update the Ala Carte's details according to user input
	 * @param menu the menu passed into
	 */
	public void updateAlacarte(ArrayList<MenuItem> menu){
		
		Scanner sc = new Scanner(System.in);
		boolean bol = false;
		if (secureAlacarteExist(menuManager)){
			System.out.print(menuManager.menuToString());
		    System.out.print("The ID of the Alacarte to update: ");
            MenuItem item = secureGetMenuItem(menuManager);
            do{
                 System.out.print("1.Name\n2.Description\n"
                  + "3.Category\n4.Price\n5.Back\nChoose which attribute to update:");
                switch(inputInteger()){
                case 1 :

                   System.out.print("The new name of the Alacarte:");
                
                   String newname = sc.nextLine();
                   for(MenuItem menuitem:menu){
                	  if(menuitem.getName().equals(newname)){
                		 System.out.println("This Ala Carte exists!");
                		 return;
                	}
                }
                   item.setName(newname);
                   break;
                case 2 :
                   System.out.print("The new description of the Alacarte: ");
                   String newdescription = sc.nextLine();
                   item.setDescription(newdescription);
                   break;
                case 3 :
                  System.out.print("The new category of the Alacarte: ");
                  String newcategory = sc.next();
                  item.setCategory(newcategory);
                  break;
                case 4 :
                  System.out.print("The new price of the Alacarte: ");
                  double newprice = inputDouble();
                  item.setPrice(newprice);
                  break;
                default:
            	    break;
               }
          System.out.print("Update any other details? ('y' to continue)");
          bol = sc.next().equals("y");
           sc.nextLine();
         }while(bol);
	  }
		else{
			System.out.println("There is no Alacarte in the menu!");
		}

	} 
	
	/**
	 * Method to update the set details according to user input
	 * @param menu the menu passed in
	 */
	public void updateSet(ArrayList<MenuItem> menu){
		Scanner sc = new Scanner(System.in);       
		boolean bol = false;
		if (secureSetExist(menuManager)){
		System.out.print(menuManager.menuToString());
		System.out.print("The ID of the Set to update: ");
        int setid = menuManager.getMenu().indexOf(secureGetMenuItem(menuManager));
        while(true){
            if((menuManager.getMenu().get(setid)) instanceof Set){
            	break;
            }
            else{
            	System.out.print("Not a Set, please choose a set ID again(-1 to back): ");
            	setid = inputInteger();
            	if (setid<=0){
            		return;
            	}
            }
		}
        do{
        	System.out.print("1.Name\n2.Description\n"
                + "3.Category\n4.Price\n5.Discountrate\n6.Add Ala Carte\n7.Delete Ala Carte\n8.Back\nChoose which attribute to update:");

		switch(inputInteger()){
            case 1 :
                System.out.print("The new name of the Set:");
                String setnewname = sc.nextLine();
                for(MenuItem menuitem:menu){
                	if(menuitem.getName().equals(setnewname)){
                		System.out.println("This Ala Carte exists!");
                		return;
                	}
                }
                menu.get(setid).setName(setnewname);
                break;
            case 2 :
                System.out.print("The new description of the Set");
                String setnewdescription = sc.nextLine();
                menu.get(setid).setDescription(setnewdescription);
                break;
            case 3 :
                System.out.print("The new category of the Set: ");
                String setnewcategory = sc.next();
                menu.get(setid).setCategory(setnewcategory);
                break;
            case 4 :
                System.out.print("The new price of the Set: ");
                double setnewprice = inputDouble();
                ((Set) menu.get(setid)).setPrice(setnewprice);
                break;
            case 5 :
                System.out.print("The new discountrate of the Set: ");
                double newdiscountrate = inputDouble();
                ((Set)menu.get(setid)).setDiscountRate(newdiscountrate);
                break;
            case 6 :
            	if(!secureAlacarteExist(menuManager)){
        			System.out.println("There is no Ala Carte in the menu!");
        		}
            	else{
            		do{
            		System.out.println(menuManager.menuToString());
    	        	System.out.print("Enter the Ala Carte ID to add into this Set: ");
    	        	int itemID = menuManager.getMenu().indexOf(secureGetMenuItem(menuManager));
    	        	if((menuManager.getMenu().get(itemID)) instanceof Set){
    	        		System.out.println("Not an Ala Carte!");
    	        	}
    	        	else{
    	        		((Set)menu.get(setid)).addAlaCartetoSet(menu, itemID);
    	        	}
    	        	
    	        	System.out.print("Add one more Ala Carte? ('y' to Continue)");
    	        	bol = sc.next().equals("y");
    	        	sc.nextLine();
    	            }while(bol);
            	}
            	break;
            case 7 :
            	if(((Set)menu.get(setid)).getSet().size() == 0){
            			System.out.println("There is no Ala Carte in the Set!");
            		}
            	else{
            		do{       		
            		((Set)menu.get(setid)).showAlaCarte();
            		System.out.print("Enter the Ala Carte ID in the Set to delete: ");
            		int itemID = inputInteger();
            		((Set)menu.get(setid)).delFromSet(itemID);
            		System.out.print("Delete one more Ala Carte?('y' to continue)");
            		bol = sc.next().equals("y");
            		sc.nextLine();
            	   }while(bol);
            	}
            	break;
            default:
                break;
         }
        System.out.print("Update any other details? ('y' to continue)");
        bol = sc.next().equals("y");
        sc.nextLine();
        }while(bol);
	   }
		else {
			System.out.println("There is no Set in the menu!");
		}
	}
    
	/**
	 * Perform the action of deleting a MenuItem
	 */
	public void deleteMenuItem(MenuManager menuManager){
		boolean bol = false;
		Scanner sc = new Scanner(System.in);
		do{
			if(menuManager.getMenu().size() == 0){
				System.out.println("No more menu item to delete! ");
				bol = false;
			}
			else{
				System.out.print(menuManager.menuToString());
			    System.out.print("The ID of the menuItem to delete:\t");
			    int itemID=menuManager.getMenu().indexOf(secureGetMenuItem(menuManager));
			    menuManager.deleteMenuItembyID(itemID);
                System.out.print("Delete one more menu item? ('y' to continue)");
                bol = sc.next().equals("y");
                sc.nextLine();
			}
		}while(bol);        	
	}
	
	/**
	 * Repeatedly asking for an integer input from user until getting one
	 * @return the integer from the user input
	 */
	private int inputInteger() {
        int integer;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.next();
                integer = Integer.parseInt(input);
                scanner.nextLine();
                break;
            } catch (NumberFormatException ne) {    //handle invalid input
                System.out.print("Not an integer, type again: ");
            }
        }
        return integer;
    }
    
	/**
	 * Repeatedly asking for a double input from user until getting one 
	 * @return the double from the user input.
	 */
    private double inputDouble(){
    	double doub;
    	Scanner sc = new Scanner(System.in);
    	while (true){
    		try{
    			String input = sc.next();
    			doub = Double.parseDouble(input);
    			//sc.nextLine();
    			break;
    		}catch(NumberFormatException ne){
    			System.out.print("Not an valid value, type again: ");
    		}
    	}
    	return doub;
    }
    
    /**
     * Repeatedly asking for a valid MenuItem ID input from user until getting one
     * @param manager pass in the instance of MenuManager
     * @param itemID the ID of the menuItem
     * @return the menuItem get from the input
     */
	public MenuItem secureGetMenuItem(MenuManager manager) {
		while (true) {
			try {
			    int itemID = inputInteger();
			    return manager.getMenuItemByld(itemID);		
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.print("Invalid ID please input again: ");
			}
		}
	}
	
	/**
	 * Check whether there is a, Ala Carte in the menu
	 * @param manager instance of control class
	 * @return true if there is an ALa Carte, flase if no Ala Carte
	 */
	public boolean secureAlacarteExist(MenuManager manager){
		for(MenuItem menuitem: manager.getMenu()){
			if (menuitem instanceof AlaCarte){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check whether there is a set in the menu
	 * @param manager instance of control class
	 * @return true if there is a Set, flase if no set
	 */
	public boolean secureSetExist(MenuManager manager){
		for(MenuItem menuitem: manager.getMenu()){
			if(menuitem instanceof Set){
				return true;
			}
		}
		return false;
	}
}


