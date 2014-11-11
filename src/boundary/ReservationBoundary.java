package boundary;

import control.ReservationManager;
import entity.Reservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
				boolean isCreated = createReservation();
				if (isCreated) {
					System.out.println("Your reservation:");
					int size = reservationManager.getReservations().size();
					System.out.println(reservationManager.getReservations()
							.get(size - 1).toString());
				}
				break;
			case 2:
				removeReservation();
				break;
			case 3:
				checkReservation();
				break;
			case 4:
				int index;
				for (index = 0; index < reservationManager.getReservations()
						.size(); ++index) {
					System.out.println((index + 1)
							+ "."
							+ reservationManager.getReservations().get(index)
									.toString());
				}
				break;
			default:
				break;
			}
		} while (choice != 5);
	}

	private boolean createReservation() {
		final String DATE_FORMAT = "dd/MM/yyyy";
		final String TIME_FORMAT = "HH:mm";
		Scanner sc = new Scanner(System.in);
		Calendar calTime = Calendar.getInstance();
		int pax;
		String cstName;
		String dateStr, timeStr;
		String[] date, time;
		boolean isValid = false;
		do {
			System.out.print("Please enter the date(DD/MM/YYYY):");
			dateStr = sc.next();
			isValid = validate(dateStr, DATE_FORMAT);
			if (!isValid)
				System.out.println("It's not a valid date! Please try again.");
		} while (!isValid);
		date = dateStr.split("/");
		do {
			System.out.print("Please enter the time(HH:MM)");
			timeStr = sc.next();
			isValid = validate(timeStr, TIME_FORMAT);
			if (!isValid)
				System.out.println("It's not a valid time! Please try again.");
		} while (!isValid);
		time = timeStr.split(":");
		calTime.set(new Integer(date[2]), new Integer(date[1]) - 1,
				new Integer(date[0]), new Integer(time[0]),
				new Integer(time[1]));
		System.out.print("Please enter the pax:");
		pax = sc.nextInt();
		System.out.print("Please enter the customer name:");
		cstName = sc.next();
		reservationManager.clearReservation();
		Reservation reservation = new Reservation(calTime, pax, cstName);
		boolean isExpired = reservationManager
				.isReservationExpired(reservation);
		if (isExpired) {
			System.out.println("Reservation is not created. It is expired.");
			return false;
		} else {
			boolean isAssigned = reservationManager.assignTable(reservation);
			if (isAssigned) {
				System.out
						.println("Reservation has been successfully created!");
				reservationManager.getReservations().add(reservation);
				return true;
			} else {
				System.out
						.println("Reservation is not created. No table is available!");
				return false;
			}
		}
	}

	private void removeReservation() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the customer name:");
		String cstName = sc.next();
		boolean isRemoved = reservationManager.removeReservation(cstName);
		if (isRemoved) {
			System.out.println("Reservation is successfully removed!");
		} else {
			System.out.println("Reservation is not removed. Please check!");
		}
	}

	private void checkReservation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the customer name:");
		String name = sc.next();
		int index = reservationManager.searchByName(name);
		if (index != -1) {
			System.out.println(reservationManager.getReservations().get(index)
					.toString());
		} else {
			System.out.println("No reservation for this customer!");
		}
	}

	private void printMenu() {
		System.out.println("1: Create new reservation");
		System.out.println("2: Remove old reservaiton");
		System.out.println("3: Check a reservation");
		System.out.println("4. Show all reservations");
		System.out.println("5: Go back");
		System.out.print("Choose any options above:");
	}

	private boolean validate(String dateStr, final String FORMAT) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(FORMAT);
			dateFormat.setLenient(false);
			dateFormat.parse(dateStr);
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}
}
