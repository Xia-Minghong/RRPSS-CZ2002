package control;

import entity.Reservation;
import entity.Table;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * ReservationManager is control class that support operations related to
 * reservation.
 * 
 * @author Wei Yumou 11-11-2014
 */
public class ReservationManager extends AbstractManager {
	/**
	 * This constant defines the threshold to determine whether a reservation is
	 * expired. If the current time exceeds the reserved time by that much, a
	 * reservation is expired.
	 */
	private final int HOURS_ALLOWED = 1;
	/**
	 * The field holds all reservations
	 */
	ArrayList<Reservation> reservations;
	/**
	 * This field provide access to control over Table objects
	 */
	TableManager tableManager;

	/**
	 * This is the constructor of this class. It will load reservations from
	 * external files.
	 * 
	 * @param tableManager
	 *            instance of a TableManager
	 * @param FILE_PATH
	 *            where the external files are located.
	 */
	public ReservationManager(TableManager tableManager, String FILE_PATH) {
		super(FILE_PATH);
		this.tableManager = tableManager;
		this.reservations = load();
	}

	/**
	 * This method is to decide whether a table is available.
	 * 
	 * @param table
	 *            specifies the targeted Table object
	 * @param curReservation
	 *            provides current reservation information
	 * @return whether a Table object is available.
	 */
	private boolean isTableAvailable(Table table, Reservation curReservation) {
		int index;
		for (index = 0; index < reservations.size(); ++index) {
			int curTableID = table.getTABLE_ID();
			int resTableID = reservations.get(index).getTable().getTABLE_ID();
			if (curTableID == resTableID) {
				if (!isReservationConflict(curReservation,
						reservations.get(index))) {
					return true;
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * This method is to determine whether two reservations conflict with each
	 * other. The criterion of conflicts is the reserved time of neither of them
	 * is within 2 hours of the other's.
	 * 
	 * @param curReservation
	 *            current reservation to be created.
	 * @param reservation
	 *            existing reservation to be compared with
	 * @return whether they conflict
	 */
	private boolean isReservationConflict(Reservation curReservation,
			Reservation reservation) {
		if (reservation.getIsCheckIn())
			return true;
		long curTime = curReservation.getTime().getTimeInMillis();
		long resTime = reservation.getTime().getTimeInMillis();
		if (Math.abs((double) curTime - (double) resTime) > HOURS_ALLOWED * 60 * 60 * 1000) {
			return false;
		}
		return true;
	}

	/**
	 * This method is to assign an available table to a certain reservation
	 * 
	 * @param reservation
	 *            current reservation to be assigned a table
	 * @return whether assignment is successful
	 */
	public boolean assignTable(Reservation reservation) {
		clearReservation();
		int index;
		int minCap = Integer.MAX_VALUE;
		Table minCapTable = null;
		ArrayList<Table> tables = tableManager.getTables();
		for (index = 0; index < tables.size(); ++index) {
			Table curTable = tables.get(index);
			int capacity = curTable.getCAPACITY();
			if (capacity >= reservation.getPax()
					&& isTableAvailable(curTable, reservation)) {
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
	/**
	 * This method is to remove a reservation by its index.
	 * 
	 * @param index
	 *            specifies the index number
	 * @return whether removal is successful.
	 */
	public boolean removeReservationByIndex(int index) {
		try {
			reservations.remove(index);
			return true;
		} catch (IndexOutOfBoundsException ex) {
			return false;
		}
	}

	/**
	 * This method is to search a certain reservation by its customer's name.
	 * 
	 * @param cstName
	 *            the customer's name to be searched
	 * @return a list of possible indices
	 */
	public ArrayList<Integer> searchByName(String cstName) {
		clearReservation();
		ArrayList<Integer> listOfIndex = new ArrayList<Integer>();
		int index;
		for (index = 0; index < reservations.size(); ++index) {
			String curName = reservations.get(index).getCstName();
			if (curName.compareTo(cstName) == 0) {
				listOfIndex.add(index);
			}
		}
		return listOfIndex;
	}

	/**
	 * This method is to search a certain reservation by the ID of its assgined
	 * table
	 * 
	 * @param TABLE_ID
	 *            specifies the table ID
	 * @return a list of possible indices
	 */
	private ArrayList<Integer> searchByTableID(final int TABLE_ID) {
		clearReservation();
		ArrayList<Integer> listOfIndex = new ArrayList<Integer>();
		int index;
		for (index = 0; index < reservations.size(); ++index) {
			int curID = reservations.get(index).getTable().getTABLE_ID();
			if (curID == TABLE_ID) {
				listOfIndex.add(index);
			}
		}
		return listOfIndex;
	}

	/**
	 * This method is to check in for certain table ID
	 * 
	 * @param TABLE_ID
	 *            specifies the table ID
	 * @return whether the check-in is successful.
	 */
	public boolean checkIn(final int TABLE_ID) {
		clearReservation();
		ArrayList<Integer> listOfIndex = searchByTableID(TABLE_ID);
		boolean done = false;
		int index;
		for (index = 0; index < listOfIndex.size() && !done; ++index) {
			Reservation curReservation = reservations.get(listOfIndex
					.get(index));
			if (isAllowCheckIn(curReservation)) {
				curReservation.setIsCheckIn(true);
				done = true;
			}
		}
		return done;
	}

	/**
	 * This method is to check whether a reservation is allowed to check in. The
	 * criterion of check-in is that current time is within 2 hours of the
	 * reserved time
	 * 
	 * @param reservation
	 *            specifies the targeted reservation
	 * @return whether this reservation can be checked in.
	 */
	private boolean isAllowCheckIn(Reservation reservation) {
		Calendar curTime = Calendar.getInstance();
		curTime.setTime(new Date());
		long currTime = curTime.getTimeInMillis();
		long resTime = reservation.getTime().getTimeInMillis();
		if (Math.abs((double) currTime - (double) resTime) <= HOURS_ALLOWED * 60 * 60 * 1000) {
			return true;
		}
		return false;
	}

	/**
	 * This method is to check out for a certain table.
	 * 
	 * @param TABLE_ID
	 *            specifies the table ID
	 * @return whether check-out is successful.
	 */
	public boolean checkOut(final int TABLE_ID) {
		clearReservation();
		ArrayList<Integer> listOfIndex = searchByTableID(TABLE_ID);
		boolean done = false;
		int index;
		for (index = 0; index < listOfIndex.size() && !done; ++index) {
			Reservation curReservation = reservations.get(listOfIndex
					.get(index));
			if (curReservation.getIsCheckIn()) {
				removeReservationByIndex(listOfIndex.get(index));
				done = true;
			}
		}
		return done;
	}

	/**
	 * This method is to remove all expired but yet checked in reservations
	 */
	private void clearReservation() {
		int index;
		for (index = 0; index < reservations.size(); ++index) {
			Reservation curReservation = reservations.get(index);
			if (isReservationExpired(curReservation)
					&& !curReservation.getIsCheckIn()) {
				removeReservationByIndex(index);
			}
		}
	}

	/**
	 * This method is to determine whether a reservation is expired.
	 * 
	 * @param reservation
	 *            specifies the targeted reservation.
	 * @return whether it is expired.
	 */
	public boolean isReservationExpired(Reservation reservation) {
		Calendar curTime = Calendar.getInstance();
		Calendar resTime = reservation.getTime();
		curTime.setTime(new Date());
		long currTime = curTime.getTimeInMillis();
		long ressTime = resTime.getTimeInMillis();
		if (currTime - ressTime > HOURS_ALLOWED * 60 * 60 * 1000) {
			return true;
		}
		return false;
	}

	/**
	 * This method is to return all reservations
	 * 
	 * @return all reservations
	 */
	public ArrayList<Reservation> getReservations() {
		clearReservation();
		return reservations;
	}

	/**
	 * This method is to set reservations to be a certain existing set of
	 * reservations
	 * 
	 * @param reservations
	 *            specifies an existing set of reservations
	 */
	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	/**
	 * This method is to load reservations from external files
	 */
	@Override
	public ArrayList<Reservation> load() {
		ArrayList<Reservation> reservations = (ArrayList<Reservation>) read();
		if (reservations == null) {
			reservations = new ArrayList<Reservation>();
		}
		return reservations;
	}

	/**
	 * This method is to save current reservations to external files.
	 */
	@Override
	public void save() {
		write(reservations);
	}
}
