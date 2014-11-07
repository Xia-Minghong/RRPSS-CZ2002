
import java.util.*;

public class Set extends MenuItem{
	
	private ArrayList<AlaCarte> set =  new ArrayList<AlaCarte>();
	
	private double discountRate;

	public Set(Set set, double discountrate){
		this.set = set;
		this.discountRate = discountrate;
	}
	
	public double getDiscountRate(){
		return this.discountRate;
	}
	
	/**
	 * 
	 */
	public void setDiscountRate(double discountrate){
		this.discountRate = discountrate;
		this.Price = 
	}
	
	public ArrayList<AlaCarte> getSet(){
		return this.set;
	}
	public void addtoSet(int  menuitemID){
		
		set.add(getMenuItemById(menuitemID));
	}
	public void delFromSet(int menuitemID){
		set.remove(getMenuItemById(menuitemID));
	}
	
	public double getPrice(){
		double sumPrice = 0;
		for (AlaCarte alacarte : set){
			sumPrice += alacarte.getPrice();
		}
		return (this.discountRate * sumPrice);
	}
		
}
