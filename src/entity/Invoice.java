package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @author Wong Chun Keet
 *
 */
public class Invoice implements Serializable{
	/**
	 * serial number of the invoice
	 */
	private final int INVOICE_ID;
	/**
	 * serial number of the order
	 */
    private final int ORDERID;
   /**
    *  time of the order
    */
	private final Calendar TIMESTAMP;
	/**
	 * is the name of staff that processed the order
	 */
    private final String STAFF_NAME;
    /**
     * the order that is being paid for, which includes all the items ordered, with their quantities and prices.
     */
    private final Order ORDER;
    /**
     * the gross price of the order less member discount if member
     */
    private final double GROSS_PRICE;
	/**
	 * tHe gst applied on tHe bill
	 */
	private final double GST;
	/**
	 * the service charge applied on the bill
	 */
	private final double SERVICE_CHARGE;
	/**
	 * the total amount payable by bustomer
	 */
	private final double NET_PRICE;
	/**
	 * name of restaurant
	 */
	private String restaurantName;

	/**
	 * constructor
	 * @param restaurantName is the name of the name of the restaurant
	 * @param INVOICE_ID is the serial number of the invoice to be created
	 * @param ORDERID is the serial number of the order that is being printed into an invoice
	 * @param TIMESTAMP is the time of placing the order
	 * @param STAFF_NAME is the name of the staff who took the order
	 * @param ORDER is the entire order of the customer, ie, all the items ordered and their quantity and price
	 * @param GROSS_PRICE is the gross total price of the order, less member discount if any
	 * @param GST is the gst charged on the order
	 * @param SERVICE_CHARGE is the service charge charged on the order
	 * @param NET_PRICE is the total amount that the customer must pay
	 */
    public Invoice(String restaurantName, int INVOICE_ID, int ORDERID, Calendar TIMESTAMP, String STAFF_NAME, Order ORDER, double GROSS_PRICE, double GST, double SERVICE_CHARGE, double NET_PRICE) {
        this.restaurantName = restaurantName;
    	this.INVOICE_ID = INVOICE_ID;
    	this.ORDERID = ORDERID;
        this.TIMESTAMP = TIMESTAMP;
        this.STAFF_NAME = STAFF_NAME;
        this.ORDER = ORDER;
        this.GROSS_PRICE = GROSS_PRICE;
        this.GST = GST;
        this.SERVICE_CHARGE = SERVICE_CHARGE;
        this.NET_PRICE = NET_PRICE;
    }
    /**
     * this method formats the date and time of the invoice for printing
     * prints out the invoice
     */
    @Override
    public String toString() {
    	int printDay=TIMESTAMP.get(Calendar.DATE);
    	int printMonth=TIMESTAMP.get(Calendar.MONTH)+1;
    	int printYear=TIMESTAMP.get(Calendar.YEAR);
    	int printHour=TIMESTAMP.get(Calendar.HOUR_OF_DAY);
    	int printMinute=TIMESTAMP.get(Calendar.MINUTE);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(restaurantName+ "\n");
        stringBuffer.append("==========================================================\n");
        stringBuffer.append("||Invoice ID:\t\t\t\t\t"+ INVOICE_ID + "\t||\n");
        stringBuffer.append("||Time:\t\t\t\t"+ String.format("%02d",printDay)+"/" +String.format("%02d",printMonth)+ "/" + String.format("%4d",printYear)+"\t"+String.format("%02d",printHour) +":"+String.format("%02d",printMinute)+"\t||\n");
        stringBuffer.append("||Staff:\t\t\t\t\t" + STAFF_NAME+ "\t||\n");
        ArrayList<OrderItem> orderItems = ORDER.getOrderItems();
        for (OrderItem orderItem : orderItems){
            stringBuffer.append("||Order Item: " + orderItem + "\t||\n");
        }
        stringBuffer.append("||Gross Price:\t\t\t\t\t"  + String.format("%.2f", GROSS_PRICE)+ "\t||\n");
        stringBuffer.append("||GST:\t\t\t\t\t\t"  + String.format("%.2f",GST)+ "\t||\n");
        stringBuffer.append("||Service Charge:\t\t\t\t"+ String.format("%.2f",SERVICE_CHARGE)+ "\t||\n");
        stringBuffer.append("----------------------------------------------------------\n");
        stringBuffer.append("||Net Price:\t\t\t\t\t" +String.format("%.2f",NET_PRICE) +"\t||\n");
        stringBuffer.append("===========================END============================\n");
        return stringBuffer.toString();
    }


    /**
     * get the time of the invoice
     * @return time of invoice
     */
    public Calendar getTIMESTAMP() {
        return TIMESTAMP;
    }
    /**
     * get the net price of the invoice
     * @return net price of the invoice
     */
    public double getNET_PRICE() {
        return NET_PRICE;
    }
    /**
     * get the order which includes the items ordered and their quantities and prices
     * @return the order
     */
    public Order getOrder(){
    	return ORDER;
    }
    /**
     * get the serial number of the order
     * @return the serial number of the order
     */
    public int getOrderID(){
    	
    	return ORDERID;
    }
    
   	
	
}