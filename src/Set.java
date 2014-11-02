
import java.util.*;

public class Set extends MenuItem{
	
	private ArrayList<AlaCarte> set =  new ArrayList<AlaCarte>();
	
	private double discountRate;

    //abstract super class has no constructor. Also when price and discountrate are input together, how
    //does the program know which to use?
	public Set(String name,String description,String category, double price, double discountrate){
		super(name,description,category, price);
		this.setDiscountRate(discountRate);
	}
	public double getDiscountRate(){
		return this.discountRate;
	}
	
	public void setDiscountRate(double discountrate){
		this.discountRate = discountrate;
	}
	
	public ArrayList<AlaCarte> getSet(){
		return this.set;
	}
	public void addtoSet(AlaCarte alacarte){
		set.add(alacarte);
	}
	public void delFromSet(AlaCarte alacarte){
		set.remove(alacarte);
	}
	
	public double getPrice(){
		double sumPrice = 0;
		for (AlaCarte alacarte : set){
			sumPrice += alacarte.getPrice();
		}
		return (this.discountRate * sumPrice);
	}
		
}
