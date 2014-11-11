package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Invoice implements Serializable{

	private final int INVOICE_ID;

    private final int ORDERID;
    
	private final Calendar TIMESTAMP;
	
    private final String STAFF_NAME;
    
    private final Order ORDER;
    
    private final double GROSS_PRICE;
	
	private final double GST;
	
	private final double SERVICE_CHARGE;
	
	private final double NET_PRICE;

	private String restaurantName;


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

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(restaurantName+ "\n");
        stringBuffer.append("=========================================================\n");
        stringBuffer.append("||Invoice ID:\t\t" + "\t\t\t"+ INVOICE_ID + "||\n");
        stringBuffer.append("||Time:\t\t\t\t"+ TIMESTAMP.get(Calendar.DATE)+"/" +TIMESTAMP.get(Calendar.MONTH)+ "/" + TIMESTAMP.get(Calendar.YEAR)+"\t"+ TIMESTAMP.get(Calendar.HOUR_OF_DAY)+":"+TIMESTAMP.get(Calendar.MINUTE)+"\t||\n");
        stringBuffer.append("||Staff:\t\t\t" + STAFF_NAME+ "\t\t\t||\n");
        ArrayList<OrderItem> orderItems = ORDER.getOrderItems();
        for (OrderItem orderItem : orderItems){
            stringBuffer.append("||" + orderItem + "||\n");
        }
        stringBuffer.append("||Gross Price:\t\t"+ "\t\t\t"  + GROSS_PRICE+ "||\n");
        stringBuffer.append("||GST:\t\t\t\t"+  + GST+ "||\n");
        stringBuffer.append("||Service Charge:\t"+ "\t\t\t"+ SERVICE_CHARGE+ "||\n");
        stringBuffer.append("---------------------------------------------------------\n");
        stringBuffer.append("||Net Price:\t\t"+ "\t\t\t" +NET_PRICE +"||\n");
        stringBuffer.append("=========================================================\n");
        return stringBuffer.toString();
    }



    public Calendar getTIMESTAMP() {
        return TIMESTAMP;
    }

    public double getNET_PRICE() {
        return NET_PRICE;
    }
    
    public Order getOrder(){
    	return ORDER;
    }
    
    public int getOrderID(){
    	
    	return ORDERID;
    }
}