package boundary;

import control.MenuManager;
import entity.MenuItem;
import entity.Set;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Cao
 * Created by root on 14-11-8.
 */
public class MenuBoundary implements Runnable{

    private MenuManager menuManager;

    public MenuBoundary(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);
        ArrayList<MenuItem> menu = menuManager.getMenu();
        while(true){
            System.out.println("1. Add New Alacarte to Menu \n"
                    + "2. Add New Set to Menu\n3. Delete MenuItem from the Menu\n4. Update the Alacarte\n"
                    +"5. Update the Set on the Menu\n6. Show all MenuItems \n7.Back\nChoose which you want: \n" );
            int choice = inputInteger();
            switch (choice){
                case 1 :
                    System.out.println("The name of the new Alacarte:");
                    String name = sc.next();
                    System.out.println("The description of the new Alacarte:");
                    String description = sc.next();
                    System.out.println("The category of the new Alacarte: ");
                    String category = sc.next();
                    System.out.println("The price of the new Alacarte:");
                    double price = inputDouble();
                    menuManager.addAlaCartetoMenu(name, description, category, price);
                    break;
                case 2 :
                	createSet(menuManager);
                    break;
                case 3:
                    System.out.print("The name of the menuItem to delete");
                    menuManager.deleteMenuItembyID(inputInteger());
                    break;
                case 4 :
                    updateAlacarte(menu);
                    break;
                case 5 :
                	updateSet(menu);
                    break;
                case 6:
                	PrintMenu();
                    break;
                default:
                	return;

            }
        }
    }
    
    public void createSet(MenuManager menuManager){
    	Scanner sc = new Scanner(System.in);
        System.out.println("The name of the new Set:");
        String setname = sc.next();
        System.out.println("The description of the new Set:");
        String setdescription = sc.next();
        System.out.println("The category of the new Set: ");
        String setcategory = sc.next();
        System.out.println("The price of the new Set:");
        double setprice = inputDouble();  
        Set newSet = menuManager.addSettoMenu(setname, setdescription, setcategory, setprice);
        if (newSet == null){
        	return;
        }
        else{
        	do{
	        	PrintMenu();
	        	System.out.println("Enter the Ala Carte ID to add into this Set: ");
	        	int itemID = inputInteger();
	        	newSet.addAlaCartetoSet(menuManager.getMenu(), itemID);
	        	System.out.println("Add one more Ala Carte? ('y' to Continue)");
	        }while(sc.next().equals("y"));
        }
  		  
    }
    
	public void updateAlacarte(ArrayList<MenuItem> menu){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("The ID of the Alacarte to update");
        int menuitemid = inputInteger();
        do{
        System.out.println(" 1.Name\n 2.Description\n"
                + "3.Category\n4.Price\n5.Back\nChoose which attribute to update: \n");
        switch(inputInteger()){
            case 1 :

                System.out.println("The new name of the Alacarte:");
                String newname = sc.next();
                for(MenuItem menuitem:menu){
                	if(menuitem.getName().equals(newname)){
                		System.out.println("This Ala Carte exists!");
                		return;
                	}
                }
                menu.get(menuitemid-1).setName(newname);
                break;
            case 2 :
                System.out.println("The new description of the Alacarte");
                String newdescription = sc.next();
                menu.get(menuitemid-1).setDescription(newdescription);
                break;
            case 3 :
                System.out.println("The new category of the Alacarte: ");
                String newcategory = sc.next();
                menu.get(menuitemid-1).setCategory(newcategory);
                break;
            case 4 :

                System.out.println("The new price of the Alacarte: ");
                double newprice = sc.nextDouble();
                menu.get(menuitemid-1).setPrice(newprice);
                break;
            default:
            	break;
        }
        System.out.println("Update any other details? ('y' to continue)");
       }while(sc.next().equals("y"));
	} 
	
	
	public void updateSet(ArrayList<MenuItem> menu){
		Scanner sc = new Scanner(System.in);
        System.out.println("The ID of the Set to update");
        int setid = sc.nextInt();
        System.out.println(" 1.Name\n 2.Description\n"
                + "3.Category\n4.Price\n5.Discountrate6.Add Ala Carte\n7.Delete Ala Carte\n8.Back\nChoose which attribute to update: \n");
        switch(sc.nextInt()){
            case 1 :
                System.out.println("The new name of the Set:");
                String setnewname = sc.next();
                for(MenuItem menuitem:menu){
                	if(menuitem.getName().equals(setnewname)){
                		System.out.println("This Ala Carte exists!");
                		return;
                	}
                }
                menu.get(setid-1).setName(setnewname);
                break;
            case 2 :
                System.out.println("The new description of the Set");
                String setnewdescription = sc.next();
                menu.get(setid-1).setDescription(setnewdescription);
                break;
            case 3 :
                System.out.println("The new category of the Set: ");
                String setnewcategory = sc.next();
                menu.get(setid-1).setCategory(setnewcategory);
                break;
            case 4 :
                System.out.println("The new price of the Set: ");
                double setnewprice = sc.nextDouble();
                ((Set) menu.get(setid-1)).setPrice(setnewprice);
                break;
            case 5 :
                System.out.println("The new discountrate of the Set: ");
                double newdiscountrate = sc.nextDouble();
                ((Set)menu.get(setid-1)).setDiscountRate(newdiscountrate);
                break;
            case 6 :
            	do{
            		PrintMenu();
    	        	System.out.println("Enter the Ala Carte ID to add into this Set: ");
    	        	int itemID = inputInteger();
    	        	((Set)menu.get(setid-1)).addAlaCartetoSet(menu, itemID);
    	        	System.out.println("Add one more Ala Carte? ('y' to Continue)");
    	        }while(sc.next().equals("y"));
            	break;
            case 7 :
            	do{
            		((Set)menu.get(setid-1)).showAlaCarte();
            		System.out.println("Enter the Ala Carte ID in the Set to delete: ");
            		int itemID = inputInteger();
            		((Set)menu.get(setid-1)).delFromSet(itemID);
            		System.out.println("Delete one more Ala Carte?('y' to continue)");
            	}while(sc.next().equals("y"));
            	break;
            default:
                break;
        }
	}
    
	
	/**
	 * Show all the menuItems in the menu with their attributes.
	 */

	public void PrintMenu(){
		System.out.println("===========Menu===========");
		for (MenuItem menuitem : menuManager.getMenu()){
			System.out.println("***********************");
		    System.out.println("ID"+(menuManager.getMenu().indexOf(menuitem)+1) + "\n"+"Name:\t" +menuitem.getName() +"\n"+"Category:\t"+ menuitem.getCategory() +"\n"+"Description:\t"+ menuitem.getDescription() +
		    		            "\n"+menuitem+"Price:\t"+ menuitem.getPrice());
		}
		System.out.println("===========End=============");
	}
	private int inputInteger() {
        int integer;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.next();
                integer = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ne) {    //handle invalid input
                System.out.print("Not an integer, type again: ");
            }
        }
        return integer;
    }
    
    private double inputDouble(){
    	double doub;
    	Scanner sc = new Scanner(System.in);
    	while (true){
    		try{
    			String input = sc.next();
    			doub = Double.parseDouble(input);
    			break;
    		}catch(NumberFormatException ne){
    			System.out.println("Not an integer, type again: ");
    		}
    	}
    	return doub;
    }
}

