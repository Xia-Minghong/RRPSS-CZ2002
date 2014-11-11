package boundary;

import control.StaffManager;

import java.util.Scanner;

import entity.Staff;

public class StaffBoundary implements Runnable{
	
	private StaffManager staffManager;
	
	public StaffBoundary(StaffManager staffManager){
		this.staffManager = staffManager;
        init();
	}
	
	public void showMenu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose action :\n\t 1. Add Staff\n\t2. Delete staff\n\t"
				+ "3.Update Staff\n\t4. Back");
		switch(sc.nextInt()){
		    case 1:
		    	addStaffs();
		    	break;
		    case 2:
		    	delStaff(); 
		    	break;
		    case 3:
		    	updateStaff();
		    	break;
		    case 4 :
		    	break;
		}
	}
	
	public void init(){
		if(staffManager.getStaffs().size()==0){
			System.out.println("Initializing staffs for the restaurant");
			addStaffs();
		}
	}
	
	public void addStaffs(){
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Enter the new Staff ID:");
			int employee_id = sc.nextInt();
			System.out.println("Enter the name of the staff:");
			String name = sc.next();
			System.out.println("Enter the Gender:(true for male and false for female)");
			boolean gender = sc.nextBoolean();
			System.out.println("Enter the job Title: ");
			String jobtitle = sc.next();
			staffManager.createStaff(employee_id, name, gender, jobtitle);
			System.out.print("Add another staff? ('y' to continue) :");
		}while(sc.next().equals("y"));
	}
	
	public void delStaff(){
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter the name of the Staff to delete:");
			String  name = sc.next();
			staffManager.deleteStaff(name);
			System.out.println("Delete one more staff?('y' to continue):");
		}while(sc.next().equals("y"));
		
	}
	
	public void updateStaff(){
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Enter the ID of the staff who need to be update:");
			int employee_id = sc.nextInt();
			Staff toUpdateStaff = staffManager.getStaffbyID(employee_id);
			System.out.println("Choose which one to update:\n\t1.Staff's Name\n\t"
					+ "2.Staff's Gender\n\t3.Staff's Job Title\n\t4.Back");
			switch(sc.nextInt()){
			   case 1:
				   System.out.println("Enter the new name");
				   String newName = sc.next();
				   toUpdateStaff.setStaffName(newName);
				   break;
			   case 2:
				   System.out.println("Enter the correct Gender (m for male, f for female): ");
                   String gender;
                   boolean corrGender;
                   while (true) {
                       gender = sc.next();
                       if (gender.equals("m") || gender.equals("f")) {
                           corrGender = gender.equals("m");
                           break;
                       }
                       System.out.println("Invalid gender, try again");
                   }

				   toUpdateStaff.setGender(corrGender);
				   break;
			   case 3: 
				   System.out.println("Enter the new Job Title:");
				   String newJobTitle = sc.next();
				   toUpdateStaff.setJobTitle(newJobTitle);
				   break;
			   case 4:
				   break;
			}
			System.out.println("Update one more staff?('y' to continue)");
		}while(sc.next().equals('y'));
	}

    @Override
	public void run(){
		showMenu();
	}
	

}
