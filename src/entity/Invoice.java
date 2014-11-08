package entity;

import java.util.ArrayList;
import java.util.Date;

public class Invoice{

	private final int INVOICE_ID;

    private final Date TIMESTAMP;
	
    private final String STAFF;
    
    private final Order ORDER;
    
    private final double GROSS_PRICE;
	
	private final double GST;
	
	private final double SERVICE_CHARGE;
	
	private final double NET_PRICE;


    public Invoice(int INVOICE_ID, Date TIMESTAMP, String STAFF, Order ORDER, double GROSS_PRICE, double GST, double SERVICE_CHARGE, double NET_PRICE) {
        this.INVOICE_ID = INVOICE_ID;        
        this.TIMESTAMP = TIMESTAMP;
        this.STAFF = STAFF;
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
		System.out.println("Staff :" + STAFF);
		ArrayList<OrderItem> orderItems = ORDER.getOrderItems();
		for (OrderItem orderItem : orderItems){
			System.out.println(orderItem);
		}
		System.out.println("Gross Price:"+ GROSS_PRICE);
		System.out.println("GST: "+ GST);
		System.out.println("Service Charge: "+ SERVICE_CHARGE);
		System.out.println("Net Price: "+ NET_PRICE);	
}










}