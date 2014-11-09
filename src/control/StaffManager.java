package control;

import java.util.ArrayList;

import entity.Staff;

public class StaffManager extends AbstractManager{

	private ArrayList<Staff> staffs;
	
	public StaffManager(String FILE_PATH){
		super(FILE_PATH);
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
	
	public ArrayList<Staff> getStaffs(){
		return this.staffs;
	}
	
	public Staff getStaffbyID(int staffID){
		for(Staff staff: staffs){
			if(staff.getStaffID() == staffID){
				return staff;
			}
		}
		return null;
	}

    @Override
	public ArrayList<Staff> load(){
        ArrayList<Staff> staffs = (ArrayList<Staff>) read();
        if (staffs == null) {
            staffs = new ArrayList<Staff>();
        }
        return staffs;
	}
	
	@Override
	public void save(){
		if(!write(staffs)){
			System.out.println("Error saving staffs to file");
		}
	}
    
	
	
	
	
	
}
