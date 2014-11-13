package entity;

import java.io.Serializable;
import java.util.Calendar;

/**
 * This entity class defines Reservation object
 * 
 * @author Wei Yumou
 * 
 */
public class Reservation implements Serializable {
	/**
	 * The reserved time
	 */
	private Calendar time;
	/**
	 * The number of customers
	 */
	private int pax;
	/**
	 * The name of customer who made this reservation
	 */
	private String cstName;
	/**
	 * Table assigned to this reservation
	 */
	private Table table;
	/**
	 * Check-in status.
	 */
	private boolean isCheckIn;

	/**
	 * This constructor initializes time, pax and customer name.
	 * 
	 * @param time
	 *            contains reserved time
	 * @param pax
	 *            contains expected number of customers
	 * @param cstName
	 *            contains booker's name
	 */
	public Reservation(Calendar time, int pax, String cstName) {
		this.setTime(time);
		this.setPax(pax);
		this.setCstName(cstName);
		this.setTable(null);
		this.setIsCheckIn(false);
	}

	/**
	 * This is the accessor method of time field.
	 * 
	 * @return reserved time
	 */
	public Calendar getTime() {
		return this.time;
	}

	/**
	 * This is the mutator method of time field.
	 * 
	 * @param time
	 */
	public void setTime(Calendar time) {
		this.time = time;
	}

	/**
	 * This is the accessor method of pax field.
	 * 
	 * @return pax
	 */
	public int getPax() {
		return pax;
	}

	/**
	 * This is the mutator method of pax field.
	 * 
	 * @param pax
	 */
	public void setPax(int pax) {
		this.pax = pax;
	}

	/**
	 * This is the accessor method of cstName field
	 * 
	 * @return cstName
	 */
	public String getCstName() {
		return this.cstName;
	}

	/**
	 * This is the mutator method of cstName.
	 * 
	 * @param cstName
	 */
	public void setCstName(String cstName) {
		this.cstName = cstName;
	}

	/**
	 * This is the accessor method of table field.
	 * 
	 * @return table
	 */
	public Table getTable() {
		return this.table;
	}

	/**
	 * This is the mutator method of table field.
	 * 
	 * @param table
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * This is the accessor method of isCheckIn.
	 * 
	 * @return
	 */
	public boolean getIsCheckIn() {
		return this.isCheckIn;
	}

	/**
	 * This is the mutator method of checkIn field
	 * 
	 * @param checkIn
	 */
	public void setIsCheckIn(boolean checkIn) {
		this.isCheckIn = checkIn;
	}

	/**
	 * The method is to print out information about this reservation
	 */
	@Override
	public String toString() {
		return "Customer Name:" + this.cstName + " Pax:" + this.pax + "\nTime:"
				+ this.time.get(Calendar.DATE) + "/"
				+ (time.get(Calendar.MONTH) + 1) + "/"
				+ time.get(Calendar.YEAR) + " "
				+ time.get(Calendar.HOUR_OF_DAY) + ":"
				+ String.format("%02d", time.get(Calendar.MINUTE))
				+ "\nAssigned table: " + table.toString() + " Checked in? "
				+ this.getIsCheckIn();
	}
}
