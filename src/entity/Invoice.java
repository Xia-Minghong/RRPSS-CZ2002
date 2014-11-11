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

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("======================================================\n");
        stringBuffer.append("||Invoice ID:\t\t" + INVOICE_ID + "\t||\n");
        stringBuffer.append("||Time:\t\t\t\t"+ TIMESTAMP+ "\t||\n");
        stringBuffer.append("||Staff:\t\t\t" + STAFF_NAME+ "\t||\n");
        ArrayList<OrderItem> orderItems = ORDER.getOrderItems();
        for (OrderItem orderItem : orderItems){
            stringBuffer.append("||" + orderItem + "\t||\n");
        }
        stringBuffer.append("||Gross Price:\t\t"+ GROSS_PRICE+ "\t||\n");
        stringBuffer.append("||GST:\t\t\t\t"+ GST+ "\t||\n");
        stringBuffer.append("||Service Charge:\t"+ SERVICE_CHARGE+ "\t||\n");
        stringBuffer.append("||Net Price:\t\t"+ NET_PRICE+ "\t||\n");
        stringBuffer.append("======================================================\n");
        return stringBuffer.toString();
    }



    public Calendar getTIMESTAMP() {
        return TIMESTAMP;
    }

    public double getNET_PRICE() {
        return NET_PRICE;
    }
}