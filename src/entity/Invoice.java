package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @author Brian
 *
 */
public class Invoice implements Serializable{
	/**
	 * 
	 */
	private final int INVOICE_ID;
	/**
	 * 
	 */
    private final int ORDERID;
   /**
    *  
    */
	private final Calendar TIMESTAMP;
	/**
	 * 
	 */
    private final String STAFF_NAME;
    /**
     * 
     */
    private final Order ORDER;
    /**
     * 
     */
    private final double GROSS_PRICE;
	/**
	 * 
	 */
	private final double GST;
	/**
	 * 
	 */
	private final double SERVICE_CHARGE;
	/**
	 * 
	 */
	private final double NET_PRICE;
	/**
	 * 
	 */
	private String restaurantName;

	/**
	 * 
	 * @param restaurantName
	 * @param INVOICE_ID
	 * @param ORDERID
	 * @param TIMESTAMP
	 * @param STAFF_NAME
	 * @param ORDER
	 * @param GROSS_PRICE
	 * @param GST
	 * @param SERVICE_CHARGE
	 * @param NET_PRICE
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
     * 
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
     * 
     * @return
     */
    public Calendar getTIMESTAMP() {
        return TIMESTAMP;
    }
    /**
     * 
     * @return
     */
    public double getNET_PRICE() {
        return NET_PRICE;
    }
    /**
     * 
     * @return
     */
    public Order getOrder(){
    	return ORDER;
    }
    /**
     * 
     * @return
     */
    public int getOrderID(){
    	
    	return ORDERID;
    }
    
   	
	
}