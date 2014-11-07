
import java.util.*;

public class Set extends MenuItem{
	
	private ArrayList<AlaCarte> set =  new ArrayList<AlaCarte>();
	
	private double discountRate;
	
	public Set(String name, String description, String category, double discountrate){
		super(name,description, category);
		this.discountRate = discountrate;
	}

	}
	
	public double getDiscountRate(){
		return this.discountRate;
	}
	
	/**
	 * 
	 */
	public void setDiscountRate(double discountrate){
		this.discountRate = discountrate;
		this.Price = this.getPrice() * discountrate;
	}
	
	public ArrayList<AlaCarte> getSet(){
		return this.set;
	}
	public void addtoSet(Menu menu,int  menuitemID){
		
		set.add(menu.getMenuItemById(menuitemID));
	}
	public void delFromSet(int menuitemID){
		set.remove(menu.getMenuItemByld(menuitemID));
	}
	
	public double getPrice(){
		double sumPrice = 0;
		for (AlaCarte alacarte : set){
			sumPrice += alacarte.getPrice();
		}
		return (this.discountRate * sumPrice);
	}
	

	@Override
	public void setPrice(double price) {
		this.Price = price;
		this.discountRate = price/this.getPrice();		
	}
		
}
