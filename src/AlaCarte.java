

public class AlaCarte extends MenuItem {
	
	private double Price;
	
	public AlaCarte(String name, String description, String category, double price){
		super(name,description,category,price);
	}
	
	public double getPrice(){ 
		return this.Price;
	}
	

}
