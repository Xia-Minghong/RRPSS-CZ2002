
import java.util.*;

public class Menu {
	
	private ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	
	public void addMenuItem(String name,String description, String category, double price){
		MenuItem menuitem = new AlaCarte(name, description,category,price);
		menu.add(menuitem);
		
	}
	public void deleteMenuItem(){
		
	}
	public void updateMenuItem(){
		
		
	}
	public void showAllItem(){
		for (MenuItem item : menu){
		System.out.println(item.getName() + item.getCategory() + item.getDescription() + item.getPrice());
		}
	}
	public MenuItem getMenuItemByld(int item){
		
		return menu.get(item);
	}

}
