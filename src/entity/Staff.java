package entity;

public class Staff{

	private String name;
	
	private final int EMPLOYEE_ID;
	
	private  Boolean gender;
	
	private String jobTitle;
	


	public Staff(int EMPLOYEE_ID, String name, Boolean gender, String jobTitle){
		this.EMPLOYEE_ID = EMPLOYEE_ID;
		this.name = name;
		this.gender = gender;
		this.jobTitle = jobTitle;
		
		}
	
	public String getStaffName(){
		return this.name;
	}
	public int getStaffID(){
		return this.EMPLOYEE_ID;
		}
	/** obtain employee name using EMPLOYEE_ID for places where print is required */
	public void setJobTitle(String jobTitle){
		this.jobTitle = jobTitle;}
	/** set staff's job title (may not be essential for purpose of this project)*/
}
