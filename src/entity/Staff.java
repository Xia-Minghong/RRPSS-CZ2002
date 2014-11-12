package entity;

import java.io.Serializable;

/**
 * Staff is a model class which holds the relvant attributes of a staff
 * and provides the mutators and accessors accordingly.
 * @author Cao Gaoxu
 * @version 1.0
 * @since 2014-11-08
 */
public class Staff implements Serializable{

	/**
	 * The name of the staff
	 */
	private String name;
	
	/**
	 * The final staff ID of the Staff
	 */
	private final int EMPLOYEE_ID;
	
	/**
	 * The gender of the staff
	 */
	private  Boolean gender;
	
	/**
	 * The job title of the staff
	 */
	private String jobTitle;
	
	/**
	 * Constructor for the staff
	 * @param EMPLOYEE_ID, the staff ID to be used in constructor
	 * @param name, the name of staff to be used in constructor
	 * @param gender, the gender of the staff to be used in constructor
	 * @param jobTitle, the job title of the staff to be used in constructor
	 */
	public Staff(int EMPLOYEE_ID, String name, Boolean gender, String jobTitle){
		this.EMPLOYEE_ID = EMPLOYEE_ID;
		this.name = name;
		this.gender = gender;
		this.jobTitle = jobTitle;
		
		}
	
	/**
	 * Getter method to get the staff name
	 * @return the name of the staff
	 */
	public String getStaffName(){
		return this.name;
	}
	
	/**
	 * Setter method to set the staff's name
	 * @param name,the new name to set to the staff
	 */
	public void setStaffName(String name){
		this.name = name;
	}
	
	/**
	 * Getter method to get the staff's ID
	 * @return the ID of the staff
	 */
	public int getStaffID(){
		return this.EMPLOYEE_ID;
		}
	
	/**
	 * Getter method to get staff's gender
	 * @return the gender of the staff
	 */
	public boolean getGender(){
		return this.gender;
	}
	
	/**
	 * Setter method to set staff's gender
	 * @param gender, the correct gender to set to the staff
	 */
	public void setGender(boolean gender){
		this.gender =gender;
	}
	
	/**
	 * Getter method to get staff's job title
	 * @return the job tile of the staff
	 */
	public String getJobTitle(){
		return this.jobTitle;
	}
	/** obtain employee name using EMPLOYEE_ID for places where print is required */
	public void setJobTitle(String jobTitle){
		this.jobTitle = jobTitle;}
	/** set staff's job title (may not be essential for purpose of this project)*/
}
