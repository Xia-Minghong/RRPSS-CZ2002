package control;

import java.util.ArrayList;

import entity.Staff;

/**
 * The control class for staff related logic/use cases
 * @author Cao Gaoxu
 * @version 1.0
 * @since 2014-11-08
 *
 */
public class StaffManager extends AbstractManager{
	
	/**
	 * An ArrayList of staffs holding staff instances to mimic the behavior of a database
	 * Each query to this list is equivalent to a query to a database 
	 */
	private ArrayList<Staff> staffs;
	
	/**
	 * Constructor for StaffManager Class
	 * @param FILE_PATH the file path from/to which the serialized stream of array list of tables is read/stored
	 */
	public StaffManager(String FILE_PATH){
		super(FILE_PATH);
		this.staffs = load();
	}
	
	/**
	 * Perform the action of adding a staff
	 * @param Employee_Id the Staff ID of new Staff
	 * @param name the name of the new staff
	 * @param gender the correct gender of the new staff
	 * @param jobtitle the job title of the new staff
	 */
	public void createStaff(int Employee_Id,String name, Boolean gender, String jobtitle){
		for(Staff staff:staffs){
			if(staff.getStaffID() == Employee_Id){
				System.out.println("The Staff ID exists! Please check!");
				return;
			}
		}
		Staff newStaff = new Staff(Employee_Id, name, gender,jobtitle);
		staffs.add(newStaff);
		System.out.println("New staff is added.");
	}
	
	/**
	 * Perform the action of deleting a staff
	 * @param name the name of the staff to delete
	 */
	public void deleteStaff(String name){
		int index = -1;
		for (Staff staff : staffs){
			if(staff.getStaffName().equals(name)){
				index = staffs.indexOf(staff);
				break;
			}
		}
		if(index != -1){
			staffs.remove(index);
		}
	}
	
	/**
	 * Getter method to get the ArrayList of staffs
	 * @return the ArrayList of the staffs
	 */
	public ArrayList<Staff> getStaffs(){
		return this.staffs;
	}
	
	/**
	 * Getter method to get the staff according to input ID
	 * @param staffID the ID of the staff to get
	 * @return the staff
	 */
	public Staff getStaffbyID(int staffID){
		for(Staff staff: staffs){
			if(staff.getStaffID() == staffID){
				return staff;
			}
		}
		return null;
	}

    /**
     * Customized method to read the list of staff instances from file
     * @return the list of staff instances read from the file or empty list if cannot read staff
     */
	@Override
	public ArrayList<Staff> load(){
        ArrayList<Staff> staffs = (ArrayList<Staff>) read();
        if (staffs == null) {
            staffs = new ArrayList<Staff>();
        }
        return staffs;
	}
	
	/**
	 * Customized method to write the list of staff instances to file
	 */
	@Override
	public void save(){
		if(!write(staffs)){
			System.out.println("Error saving staffs to file");
		}
	}
    
	
	
	
	
	
}
