package entity;

import control.MenuManager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Set is a model class which holds the relevant attributes
 * of a set and provides the mutators and accessors accordingly
 * @author Cao Gaoxu
 *
 */
public class Set extends MenuItem implements Serializable{
	
	/**
	 * 
	 */
	private ArrayList<AlaCarte> set =  new ArrayList<AlaCarte>();
	
	private double discountRate;
	
	public Set(String name, String description, String category, double price){
		super(name,description, category);
		this.Price = price;
		this.discountRate = 1;
	}

	public double getDiscountRate(){
		return this.discountRate;
	}
	
	/**
	 * 
	 * @param discountrate
	 */
	public void setDiscountRate(double discountrate){
		this.discountRate = discountrate;
		this.Price = this.getPrice() * discountrate;
	}
	
	public ArrayList<AlaCarte> getSet(){
		return this.set;
	}
	
	public void addAlaCartetoSet(ArrayList<MenuItem> menu,int  menuitemID){
		while(true){
			 try{
			 AlaCarte alacarte = (AlaCarte) menu.get(menuitemID-1);
			 set.add(alacarte);
			 return;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid ID please input again!");
			return;
		 }
	  
		}
	}
	public void delFromSet(int menuitemID){
		if(this.getSet().size() == 0){
			System.out.println("No more Ala Carte to delete!");
		}
		else{
			while(true){
				try{
				AlaCarte alacarte = this.set.get(menuitemID-1);
				set.remove(menuitemID-1);
				return;
			    }catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Invalid ID please input again!");
				return;
			}
		}	    
	   }
	}
	
	public double getDiscountPrice(){
		double sumPrice = 0;
		for (AlaCarte alacarte : set){
			sumPrice += alacarte.getPrice();
		}
		return (this.discountRate * sumPrice);
	}
	public double getPrice(){
		return this.Price;
	}
	

	@Override
	public void setPrice(double price) {
		this.Price = price;
		this.discountRate = price/this.getPrice();		
	}
	
	public void showAlaCarte(){
		System.out.println("==========="+this.getName()+"===========");
		for (AlaCarte alacarte : this.getSet()){
			System.out.println("***********************");
		    System.out.println("ID\t"+(this.getSet().indexOf(alacarte)+1) + "\n"+"Name:\t" +alacarte.getName() +"\n"+"Category:\t"+ alacarte.getCategory() +"\n"+"Description:\t"+ alacarte.getDescription() +
		    		            "\n"+"Price:\t"+ alacarte.getPrice());
		}
		System.out.println("===========End=============\n");
	}
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

