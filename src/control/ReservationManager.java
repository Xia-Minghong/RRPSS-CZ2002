package control;

import entity.Reservation;
import entity.Table;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class ReservationManager extends PersistentManager{
	private final int HOURS_ALLOWED = 1;
    ArrayList<Reservation> reservations;

	private boolean isTableAvailable(Table table,
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

	private boolean isReservationVoid(Reservation reservation) {
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

	private boolean assignTable(Reservation reservation,
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

	private boolean removeReservation(String cstName,
			ArrayList<Reservation> reservations) {
		int index = searchByName(cstName, reservations);
		if (index != -1) {
			reservations.remove(index);
			return true;
		}
		return false;
	}

	private int searchByName(String cstName,
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

	public void clearReservation() {
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

    @Override
    public void save() {
        write(reservations);
    }
}
