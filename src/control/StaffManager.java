package control;

import java.util.ArrayList;

import entity.Staff;

public class StaffManager {

	
	private final String FILE_PATH;
	
	private ArrayList<Staff> staffs;
	
	public StaffManager(String FILE_PATH){
		this.FILE_PATH = FILE_PATH;
		this.staffs = load();
	}
	
	public void createStaff(int Employee_Id,String name, Boolean gender, String jobtitle){
		Staff newStaff = new Staff(Employee_Id, name, gender,jobtitle);
		staffs.add(newStaff);
	}
	
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
	
	public Staff getStaffbuID(int staffID){
		for(Staff staff: staffs){
			if(staff.getStaffID() == staffID){
				return staff;
			}
		}
		return null;
	}
	
	public ArrayList<Staff> load(){
		Object object = IOManager.read(FILE_PATH);
		if(object instanceof ArrayList<?> && ((ArrayList<?>) object).get(0) instanceof Staff){
			return (ArrayList<Staff>) object;
			
		}
		System.out.println("Error loading staffs from file");
		return null;
	}
	
	
	public void save(){
		if(!IOManager.write(staffs, FILE_PATH)){
			System.out.println("Error saving staffs to file");
		}
	}
    
	
	
	
	
	
}
