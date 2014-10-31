
public abstract class MenuItem {
	
	private String Name;
	
	private String Description;
	
	private String Category;
	
	/**
	 * 
	 * @param name
	 * @param description
	 * @param category
	 * @param price
	 */
	public MenuItem(String name, String description, String category, double price){
		this.setName(name);
		this.setDescription(description);
		this.setCategory(category);
		this.setPrice(price);
	}
	
	public String getName(){
		return this.Name;
	}
	/**
	 * 
	 * @param Name
	 */
	public void setName(String Name){
		this.Name = Name;
	}
	
	public String getDescription(){
		return this.Description;
	}
	
	public void setDescription(String description){
		this.Description = description;
	}
	
	public String getCategory(){
		return this.Category;
	}
	
	public void setCategory(String category){
		this.Category = category;
	}
	public abstract double getPrice();

	public void setPrice(double price){
	}
	

}
