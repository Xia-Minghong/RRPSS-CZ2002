package boundary;

import control.MenuManager;
import entity.MenuItem;
import entity.Set;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by root on 14-11-8.
 */
public class MenuBoundary {

    private MenuManager menuManager;

    public MenuBoundary(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        ArrayList<MenuItem> menu = menuManager.getMenu();
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
                    menuManager.addAlaCartetoMenu(name, description, category, price);
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
                    menuManager.addSet(setname, setdescription, setcategory, setdiscountrate);
                    break;
                case 3:
                    System.out.print("The name of the menuItem to delete");
                    menuManager.deleteMenuItem(sc.next());
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
                    menuManager.showAllItem();
                    break;

            }
        }
    }
}
