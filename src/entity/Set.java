package entity;

import control.MenuManager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Set is a model class which holds the relevant attributes
 * of a set and provides the mutators and accessors accordingly
 * @author Cao Gaoxu
 *@version 1.0
 *@since 2014-11-06
 */
public class Set extends MenuItem implements Serializable{
	
	/**
	 * An ArrayList of Ala Cartes holding the Ala Carte instances to mimic the behaviour of database
	 * Each query to this list is equivalent to a query to a database
	 */
	private ArrayList<AlaCarte> set =  new ArrayList<AlaCarte>();
	
	
	/**
	 * The discountTate used to claculate the price
	 */
	private double discountRate;
	
	/**
	 * Constructor for the Set
	 * @param name, the name of the Set
	 * @param description, the words used to describe the Set
	 * @param category, the category of the Set
	 * @param price, the price of the Set
	 */
	public Set(String name, String description, String category, double price){
		super(name,description, category);
		this.Price = price;
		this.discountRate = 1;
	}
	
	/**
	 * Getter method for Set discount rate
	 * @return the discount rate of the Set
	 */
	public double getDiscountRate(){
		return this.discountRate;
	}
	
	/**
	 * Setter method for Set discount rate
	 * @param discountrate,the value to set to discount rate
	 */
	public void setDiscountRate(double discountrate){
		this.discountRate = discountrate;
		this.Price = this.getPrice() * discountrate;
	}
	
	/**
	 * Getter method to get the Set
	 * @return the Set
	 */
	public ArrayList<AlaCarte> getSet(){
		return this.set;
	}
	
	/**
	 * Add method to add an Ala Carte into the Set
	 * @param menu, the menu contains all Ala Carte
	 * @param menuitemID, the ID of the Ala Carte to add into set
	 */
	public void addAlaCartetoSet(ArrayList<MenuItem> menu,int  menuitemID){
			 set.add((AlaCarte) menu.get(menuitemID));
		 
	}
	
	/**
	 * delete method to delete an Ala Carte from the set
	 * @param menuitemID, the ID of the Ala Carte to delete from the set
	 */
	public void delFromSet(int menuitemID){
		if(this.getSet().size() == 0){
			System.out.println("No more Ala Carte to delete!");
		}
		else{
			while(true){
				try{
				AlaCarte alacarte = this.set.get(menuitemID);
				set.remove(menuitemID);
				return;
			    }catch(IndexOutOfBoundsException e){
				System.out.println("Invalid ID please input again!");
				return;
			}
		}	    
	   }
	}
	
	/**
	 * Getter method for the set price after discount
	 * @return the price of the set after discount
	 */
	public double getDiscountPrice(){
		double sumPrice = 0;
		for (AlaCarte alacarte : set){
			sumPrice += alacarte.getPrice();
		}
		return (this.discountRate * sumPrice);
	}
	
	/**
	 * Getter method for the set price
	 * @return the price of the set
	 */
	public double getPrice(){
		return this.Price;
	}
	
	/**
	 * Setter method to set the price of the Set
	 * @param price, the price to set to the Set
	 */
	@Override
	public void setPrice(double price) {
		this.Price = price;
		this.discountRate = price/this.getPrice();		
	}
	
	/**
	 * Method to show all the Ala Carte inside the Set
	 */
	public void showAlaCarte(){
		System.out.println("==========="+this.getName()+"===========");
		for (AlaCarte alacarte : this.getSet()){
			System.out.println("***********************");
		    System.out.println("ID\t"+(this.getSet().indexOf(alacarte)+1) + "\n"+"Name:\t" +alacarte.getName() +"\n"+"Category:\t"+ alacarte.getCategory() +"\n"+"Description:\t"+ alacarte.getDescription() +
		    		            "\n"+"Price:\t"+ alacarte.getPrice());
		}
		System.out.println("===========End=============\n");
	}
	
	/**
	 * Format the print string of the set
	 */
	@Override
	public String toString(){
		StringBuffer ans = new StringBuffer();
		ans.append("Type:\t\t\tSet\nName:\t\t\t"+this.getName()+"\n"+"Category:\t\t"+ this.getCategory() +"\n"+"Description:\t\t"+ this.getDescription()+"\n"+"Include:\n");
		for(AlaCarte alacarte:this.set){
			ans.append("\t\t"+(this.getSet().indexOf(alacarte)+1)+"\t"+alacarte.getName()+"\n");
		}
		ans.append("\nPrice:\t\t\t"+this.getPrice());
		return ans.toString();
	}
		
}

