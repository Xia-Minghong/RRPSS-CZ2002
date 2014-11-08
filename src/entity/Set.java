package entity;

import control.MenuManager;

import java.util.ArrayList;

public class Set extends MenuItem{
	
	private ArrayList<AlaCarte> set =  new ArrayList<AlaCarte>();
	
	private double discountRate;
	
	public Set(String name, String description, String category, double discountrate){
		super(name,description, category);
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
		this.Price = this.getPrice() * discountrate;
	}
	
	public ArrayList<AlaCarte> getSet(){
		return this.set;
	}
	public void addtoSet(MenuManager menu,int  menuitemID){
		
		set.add((AlaCarte)menu.getMenuItemByld(menuitemID));
	}
	public void delFromSet(MenuManager menu,int menuitemID){
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
