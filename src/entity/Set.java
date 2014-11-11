package entity;

import control.MenuManager;

import java.io.Serializable;
import java.util.ArrayList;

public class Set extends MenuItem implements Serializable{
	
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
		    System.out.println("ID"+(this.getSet().indexOf(alacarte)+1) + "\n"+"Name:\t" +alacarte.getName() +"\n"+"Category:\t"+ alacarte.getCategory() +"\n"+"Description:\t"+ alacarte.getDescription() +
		    		            "\n"+"Price:\t"+ alacarte.getPrice());
		}
		System.out.println("===========End=============\n");
	}
	@Override
	public String toString(){
		StringBuffer ans = new StringBuffer();
		ans.append("Name:\t\t\t"+this.getName()+"\n"+"Category:\t\t"+ this.getCategory() +"\n"+"Description:\t"+ this.getDescription()+"\n"+"Include:");
		for(AlaCarte alacarte:this.set){
			ans.append("\t\t\t"+this.getSet().indexOf(alacarte)+"\t"+alacarte.getName()+"\n");
		}
		ans.append("Price:\t"+this.getPrice());
		return ans.toString();
	}
		
}

