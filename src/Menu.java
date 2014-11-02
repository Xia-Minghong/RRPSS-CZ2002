
import java.util.*;

public class Menu {
	//Change Menu to static
	private static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	
	public static void addMenuItem(String name,String description, String category, double price){
		MenuItem menuitem = new AlaCarte(name, description,category,price);
		menu.add(menuitem);
		
	}
	public static void deleteMenuItem(){
		
	}
	public static void updateMenuItem(){
		
		
	}
	public static void showAllItem(){
		//by ZJY 要显示个id啊 不然怎么选是哪个，然后下标要从0开始
		for (int i = 0; i < menu.size(); i++) {
			System.out.println((i+1)+menu.get(i).getName() + menu.get(i).getCategory() + menu.get(i).getDescription() + menu.get(i).getPrice());
		}
		/*
		for (MenuItem item : menu){
		System.out.println(item.getName() + item.getCategory() + item.getDescription() + item.getPrice());
		}*/
		
	}
	public static MenuItem getMenuItemByld(int item){
		//下标从0开始
		return menu.get(item-1);
	}

}
