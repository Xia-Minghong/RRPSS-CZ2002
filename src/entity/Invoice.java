package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Invoice implements Serializable{

	private final int INVOICE_ID;

    private final Calendar TIMESTAMP;
	
    private final String STAFF_NAME;
    
    private final Order ORDER;
    
    private final double GROSS_PRICE;
	
	private final double GST;
	
	private final double SERVICE_CHARGE;
	
	private final double NET_PRICE;


    public Invoice(int INVOICE_ID, Calendar TIMESTAMP, String STAFF_NAME, Order ORDER, double GROSS_PRICE, double GST, double SERVICE_CHARGE, double NET_PRICE) {
        this.INVOICE_ID = INVOICE_ID;
        this.TIMESTAMP = TIMESTAMP;
        this.STAFF_NAME = STAFF_NAME;
        this.ORDER = ORDER;
        this.GROSS_PRICE = GROSS_PRICE;
        this.GST = GST;
        this.SERVICE_CHARGE = SERVICE_CHARGE;
        this.NET_PRICE = NET_PRICE;
    }

	public void print(){
		System.out.println("Invoice ID" + INVOICE_ID);
		System.out.println("Time: "+ TIMESTAMP);
/** not sure how to handle timestamp  */
		System.out.println("Staff :" + STAFF_NAME);
		ArrayList<OrderItem> orderItems = ORDER.getOrderItems();
		for (OrderItem orderItem : orderItems){
			System.out.println(orderItem);
		}
		System.out.println("Gross Price:"+ GROSS_PRICE);
		System.out.println("GST: "+ GST);
		System.out.println("Service Charge: "+ SERVICE_CHARGE);
		System.out.println("Net Price: "+ NET_PRICE);
}

    public double getNET_PRICE() {
        return NET_PRICE;
    }

    public Calendar getTIMESTAMP() {
        return TIMESTAMP;
    }

}