package boundary;

import control.ReservationManager;
import entity.Reservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by root on 14-11-8.
 */
public class ReservationBoundary {

	private ReservationManager reservationManager;

	public ReservationBoundary(ReservationManager reservationManager) {
		this.reservationManager = reservationManager;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println();
			printMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				createReservation();
				break;
			case 2:
				removeReservation();
				break;
			case 3:
				checkReservation();
				break;
			case 4:
				showAllReservations();
				break;
			/*case 6:
				System.out.println("Table ID:");
				int ID = sc.nextInt();
				System.out.println(reservationManager.checkIn(ID));
				break;
			case 7:
				System.out.println("Table ID:");
				int id = sc.nextInt();
				System.out.println(reservationManager.checkOut(id));
				break;*/
			default:
				break;
			}
		} while (choice != 5);
	}

	private void createReservation() {
		final String DATE_FORMAT = "dd/MM/yyyy";
		final String TIME_FORMAT = "HH:mm";
		Scanner sc = new Scanner(System.in);
		Calendar calTime = Calendar.getInstance();
		String pax;
		String cstName;
		String dateStr, timeStr;
		String[] date, time;
		boolean isValid = false;
		do {
			System.out.print("Please enter the date(DD/MM/YYYY):");
			dateStr = sc.next();
			isValid = validateDate(dateStr, DATE_FORMAT);
			if (!isValid)
				System.out.println("It's not a valid date! Please try again.");
		} while (!isValid);
		date = dateStr.split("/");
		do {
			System.out.print("Please enter the time(HH:MM):");
			timeStr = sc.next();
			isValid = validateDate(timeStr, TIME_FORMAT);
			if (!isValid)
				System.out.println("It's not a valid time! Please try again.");
		} while (!isValid);
		time = timeStr.split(":");
		calTime.set(new Integer(date[2]), new Integer(date[1]) - 1,
				new Integer(date[0]), new Integer(time[0]),
				new Integer(time[1]));
		do{
			System.out.print("Please enter the pax:");
			pax = sc.next();
			isValid = validatePax(pax);
			if(!isValid)
				System.out.println("It's not a valid pax number! Please try again.");
		}while(!isValid);
		
		System.out.print("Please enter the customer name(no space):");
		String buffer = sc.nextLine();
		cstName = sc.nextLine();
		Reservation reservation = new Reservation(calTime, new Integer(pax), cstName);
		boolean isExpired = reservationManager
				.isReservationExpired(reservation);
		if (isExpired) {
			System.out.println("Reservation is not created. It is expired.");
		} else {
			boolean isAssigned = reservationManager.assignTable(reservation);
			if (isAssigned) {
				System.out
						.println("Reservation has been successfully created!");
				reservationManager.getReservations().add(reservation);
				
				System.out.println("Your reservation:");
				System.out.println(reservation.toString());
			} else {
				System.out
						.println("Reservation is not created. No table is available!");
			}
		}
	}

	private void removeReservation() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the customer name:");
		String cstName = sc.nextLine();
		ArrayList<Integer> listOfIndex = reservationManager.searchByName(cstName);
		System.out.println("Reservations associated with this customer:");
		int index;
		for(index = 0; index < listOfIndex.size();++index){
			System.out.print((index + 1) + ". ");
			System.out.println(reservationManager.getReservations().get(index).toString());
		}
		System.out.print("Choose one to remove:");
		int choice = sc.nextInt();
		boolean isRemoved = reservationManager.removeReservationByIndex(choice - 1);
		if (isRemoved) {
			System.out.println("Reservation is successfully removed!");
		} else {
			System.out.println("Reservation is not removed. Please check!");
		}
	}

	private void checkReservation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the customer name:");
		String name = sc.nextLine();
		ArrayList<Integer> listOfIndex = reservationManager.searchByName(name);
		System.out.println("Reservations associated with this customer:");
		int index;
		for(index = 0; index < listOfIndex.size();++index){
			System.out.print((index + 1) + ". ");
			System.out.println(reservationManager.getReservations().get(index).toString());
		}
	}

	private void printMenu() {
		System.out.println("1: Create new reservation");
		System.out.println("2: Remove old reservaiton");
		System.out.println("3: Check a reservation");
		System.out.println("4. Show all reservations");
		System.out.println("5: Go back");
		//System.out.println("6: Check in");
		//System.out.println("7: Check out");
		System.out.print("Choose any options above:");
	}

	private boolean validateDate(String dateStr, final String FORMAT) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(FORMAT);
			dateFormat.setLenient(false);
			dateFormat.parse(dateStr);
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}
	private boolean validatePax(String pax){
		try{
			Integer intPax = new Integer(pax);
			if(intPax.compareTo(0) <= 0)
				return false;
			return true;
		}catch(NumberFormatException ex){
			return false;
		}
	}
	/**
	 * This method is to print all existing reservations
	 */
	public void showAllReservations() {
		System.out.println("All reservations:");
		int index;
		for (index = 0; index < reservationManager.getReservations().size(); ++index) {
			System.out.print((index + 1) + ". ");
			System.out.println(reservationManager.getReservations().get(index).toString());
		}
	}
}
