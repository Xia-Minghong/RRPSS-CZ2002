import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class ReservationManager {
	private static final int HOURS_ALLOWED = 1;

	public static void run(ArrayList<Reservation> reservations,
			ArrayList<Table> tables) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			printMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				clearReservation(reservations);
				Reservation reservation = createReservation();
				boolean isAssigned = assignTable(reservation, tables,
						reservations);
				if (isAssigned) {
					System.out
							.println("Reservation has been successfully created!");
					reservations.add(reservation);
				} else {
					System.out
							.println("Reservation is not created. No table is available!");
				}
				break;
			case 2:
				System.out.print("Please enter the customer name:");
				String cstName = sc.next();
				boolean isRemoved = removeReservation(cstName, reservations);
				if (isRemoved) {
					System.out.println("Reservation is successfully removed!");
				} else {
					System.out
							.println("Reservation is not removed. Please check!");
				}
				break;
			case 3:
				System.out.println("Please enter the customer name:");
				String name = sc.next();
				int index = searchByName(name, reservations);
				if (index != -1) {
					System.out.println(reservations.get(index).toString());
				} else {
					System.out.println("No reservation for this customer!");
				}
				break;
			default:
				break;
			}
		} while (choice != 4);
	}

	private static Reservation createReservation() {
		Scanner sc = new Scanner(System.in);
		Calendar calTime = Calendar.getInstance();
		int pax;
		String cstName;
		String dateStr, timeStr;
		String[] date, time;

		System.out.print("Please enter the date(DD/MM/YYYY):");
		dateStr = sc.next();
		date = dateStr.split("/");
		System.out.print("Please enter the time(HH:MM)");
		timeStr = sc.next();
		time = timeStr.split(":");
		calTime.set(new Integer(date[2]), new Integer(date[1]) - 1,
				new Integer(date[0]), new Integer(time[0]),
				new Integer(time[1]));
		System.out.print("Please enter the pax:");
		pax = sc.nextInt();
		System.out.print("Please enter the customer name:");
		cstName = sc.next();
		return new Reservation(calTime, pax, cstName);
	}

	private static void printMenu() {
		System.out.println("1: Create new reservation");
		System.out.println("2: Remove old reservaiton");
		System.out.println("3: Check a reservation");
		System.out.println("4: Go back");
		System.out.print("Choose any options above:");
	}

	private static boolean isTableAvailable(Table table,
			ArrayList<Reservation> reservations) {
		int index;
		for (index = 0; index < reservations.size(); ++index) {
			int curTableID = table.getTABLE_ID();
			int resTableID = reservations.get(index).getTable().getTABLE_ID();
			if (curTableID == resTableID) {
				if (isReservationVoid(reservations.get(index)))
					return true;
			}
		}
		return false;
	}

	private static boolean isReservationVoid(Reservation reservation) {
		if (reservation.getIsCheckIn())
			return false;
		Calendar curTime = Calendar.getInstance();
		Calendar resTime = reservation.getTime();
		curTime.setTime(new Date());
		long currTime = curTime.getTimeInMillis();
		long reseTime = resTime.getTimeInMillis();
		if (Math.abs((double) currTime - (double) reseTime) > HOURS_ALLOWED * 60 * 60 * 1000) {
			return true;
		}
		return false;
	}

	private static boolean assignTable(Reservation reservation,
			ArrayList<Table> tables, ArrayList<Reservation> reservations) {
		int index;
		int minCap = Integer.MAX_VALUE;
		Table minCapTable = null;

		for (index = 0; index < tables.size(); ++index) {
			Table curTable = tables.get(index);
			int capacity = curTable.getCAPACITY();
			if (capacity >= reservation.getPax()
					&& isTableAvailable(curTable, reservations)) {
				if (capacity < minCap) {
					minCap = capacity;
					minCapTable = curTable;
				}
			}
		}
		if (minCapTable == null)
			return false;
		reservation.setTable(minCapTable);
		return true;
	}

	private static boolean removeReservation(String cstName,
			ArrayList<Reservation> reservations) {
		int index = searchByName(cstName, reservations);
		if (index != -1) {
			reservations.remove(index);
			return true;
		}
		return false;
	}

	private static int searchByName(String cstName,
			ArrayList<Reservation> reservations) {
		int index;
		for (index = 0; index < reservations.size(); ++index) {
			String curName = reservations.get(index).getCstName();
			if (curName.compareTo(cstName) == 0) {
				return index;
			}
		}
		return -1;
	}

	private static void clearReservation(ArrayList<Reservation> reservations) {
		int index;
		for (index = 0; index < reservations.size(); ++index) {
			Reservation curReservation = reservations.get(index);
			if (isReservationVoid(curReservation)) {
				Calendar curTime = Calendar.getInstance();
				Calendar resTime = curReservation.getTime();
				if (curTime.after(resTime)) {
					removeReservation(curReservation.getCstName(), reservations);
				}
			}
		}
	}
}
