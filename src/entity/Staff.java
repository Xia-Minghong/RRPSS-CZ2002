package entity;

public class Staff{

	private String name;
	
	private final int EMPLOYEE_ID;
	
	private  Boolean gender;
	
	private String jobTitle;
	


	public createStaff (int EMPLOYEE_ID, String name, Boolean GENDER, String jobTitle){
		this.EMPLOYEE_ID = EMPLOYEE_ID;
		this.name = name;
		this.gender = gender;
		this.jobTitle = jobTitle;
		
		}
	
	public String getStaffName(int EMPLOYEE_ID){
		return name;}
	/** obtain employee name using EMPLOYEE_ID for places where print is required */
	public void setJobTitle(String jobTitle){
		this.jobTitle = jobTitle;}
	/** set staff's job title (may not be essential for purpose of this project)*/
}
