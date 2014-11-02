

public class AlaCarte extends MenuItem {

	private double Price;
	//All the args passed in need to be stored in an attribute
	public AlaCarte(String name, String description, String category, double price){
		super(name,description,category,price);
	}
	
	public double getPrice(){ 
		return this.Price;
	}
	

}
