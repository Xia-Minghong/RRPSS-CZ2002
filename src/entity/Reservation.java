package entity;

import java.io.Serializable;
import java.util.Calendar;

public class Reservation implements Serializable{
	private Calendar time;
	private int pax;
	private String cstName;
	private Table table;
	private boolean isCheckIn;

	public Reservation(Calendar time, int pax, String cstName) {
		this.setTime(time);
		this.setPax(pax);
		this.setCstName(cstName);
		this.setTable(null);
		this.setIsCheckIn(false);
	}

	public Calendar getTime() {
		return this.time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public int getPax() {
		return pax;
	}

	public void setPax(int pax) {
		this.pax = pax;
	}

	public String getCstName() {
		return this.cstName;
	}

	public void setCstName(String cstName) {
		this.cstName = cstName;
	}

	public Table getTable() {
		return this.table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public boolean getIsCheckIn() {
		return this.isCheckIn;
	}

	public void setIsCheckIn(boolean checkIn) {
		this.isCheckIn = checkIn;
	}

	@Override
	public String toString() {
		return "Customer Name:" + this.cstName + "\nTime:"
				+ this.time.get(Calendar.YEAR) + " "
				+ (time.get(Calendar.MONTH) + 1) + " "
				+ time.get(Calendar.DATE) + " "
				+ time.get(Calendar.HOUR_OF_DAY) + " "
				+ time.get(Calendar.MINUTE);
	}
}
