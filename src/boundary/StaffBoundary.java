package boundary;

import control.StaffManager;

import java.util.Scanner;

import entity.Staff;

/**
 * The boundary class handling user interactions related to staffs
 * @author Cao Gaoxu
 * @version 1.0
 * @since 2014-11-07
 */
public class StaffBoundary implements Runnable{
	
	/**
	 * The reference to a staff control instance
	 */
	private StaffManager staffManager;
	
	/**
	 * Constructor of the StaffBoundary class
	 * will call init() to initialize system variable if needed
	 * @param staffManager pass in the control manager
	 */
	public StaffBoundary(StaffManager staffManager){
		this.staffManager = staffManager;
        init();
	}
	
	/**
	 * Print the menu of the actions that to be performed 
	 */
	public void showMenu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose action :\n\t 1. Add Staff\n\t2. Delete staff\n\t"
				+ "3.Update Staff\n\t4. Back");
		switch(inputInteger()){
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
	
	/**
	 * Create staffs if there is not any staff
	 */
	public void init(){
		if(staffManager.getStaffs().size()==0){
			System.out.println("Initializing staffs for the restaurant");
			addStaffs();
		}
	}
	
	/**
	 * Handles the user interactions about adding staffs
	 */
	public void addStaffs(){
		Scanner sc = new Scanner(System.in);
		boolean bol = false;
		do{
			System.out.print("Enter the new Staff ID:");
			int employee_id = inputInteger();
			System.out.print("Enter the name of the staff:");
			String name = sc.nextLine();
			System.out.print("Enter the correct Gender (m for male, f for female): ");
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
			System.out.print("Enter the job Title: ");
			sc.nextLine();
			String jobtitle = sc.nextLine();
			staffManager.createStaff(employee_id, name, corrGender, jobtitle);
			System.out.print("Add another staff? ('y' to continue) :");
			bol = sc.next().equals("y");
			sc.nextLine();
		}while(bol);
	}
	
	/**
	 * handles the user interactions about deleting staffs
	 */
	public void delStaff(){
		Scanner sc = new Scanner(System.in);
		boolean bol = false;
		do {
			System.out.println("Enter the name of the Staff to delete:");
			String  name = sc.nextLine();
			staffManager.deleteStaff(name);
			System.out.println("Delete one more staff?('y' to continue):");
			bol = sc.next().equals("y");
			sc.nextLine();
		}while(bol);
		
	}
	
    /**
     * Handles the user interaction about updating staffs
     */
	public void updateStaff(){
		Scanner sc = new Scanner(System.in);
		boolean bol = false;
		do{
			System.out.println("Enter the ID of the staff who need to be update:");
			int employee_id = inputInteger();
			Staff toUpdateStaff = staffManager.getStaffbyID(employee_id);
			System.out.println("Choose which one to update:\n\t1.Staff's Name\n\t"
					+ "2.Staff's Gender\n\t3.Staff's Job Title\n\t4.Back");
			switch(inputInteger()){
			   case 1:
				   System.out.println("Enter the new name");
				   String newName = sc.nextLine();
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
                       System.out.print("Invalid gender, try again: ");
                   }

				   toUpdateStaff.setGender(corrGender);
				   break;
			   case 3: 
				   System.out.println("Enter the new Job Title:");
				   String newJobTitle = sc.nextLine();
				   toUpdateStaff.setJobTitle(newJobTitle);
				   break;
			   case 4:
				   break;
			}
			System.out.println("Update one more staff?('y' to continue)");
			bol =sc.next().equals("y");
			sc.nextLine();
		}while(bol);
	}
	
	/**
	 * Repeatedly asking for an integer input from System.in until getting one
	 * @return the integer get from the input
	 */
	private int inputInteger() {
        int integer;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.next();
                integer = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ne) {    //handle invalid input
                System.out.print("Not an integer, type again: ");
            }
        }
        return integer;
    }

	/**
	 * Entry point of this boundary
	 */
	@Override
	public void run(){
		showMenu();
	}
	

}
