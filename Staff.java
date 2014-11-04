

public class Staff{

	private String name;
	
	private final int EMPLOYEE_ID;
	
	private final Boolean GENDER;
	
	private String jobTitle;
	
	public static int count;

	public createStaff (int EMPLOYEE_ID, String name, Boolean GENDER, String jobTitle){
		this.EMPLOYEE_ID = count;
		this.name = name;
		this.GENDER = GENDER;
		this.jobTitle = jobTitle;
		count++;
		}
	
	public String getStaffName(int EMPLOYEE_ID){
		return name;}
	/** obtain employee name using EMPLOYEE_ID for places where print is required */
	public void setJobTitle(String jobTitle){
		this.jobTitle = jobTitle;}
	/** set staff's job title (may not be essential for purpose of this project)*/
}
