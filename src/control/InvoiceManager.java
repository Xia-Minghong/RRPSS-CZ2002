package control;

import entity.Invoice;
import entity.Order;
import entity.Staff;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceManager{


private int index;

private final double GST_RATE;

private final double SERVICE_CHARGE_RATE;

private ArrayList<Invoice> invoices;

public InvoiceManager(ArrayList<Invoice> invoices, double GST_RATE, double SERVICE_CHARGE_RATE) {
           
	this.invoices = invoices;
	
    this.GST_RATE = GST_RATE;
    
    this.SERVICE_CHARGE_RATE = SERVICE_CHARGE_RATE;

}

public void createInvoice(int orderID){
	Order order = orderManager.getOrderbyID(orderID);
	Staff staff = staffManager.getStaffbyID(staffID)
	private static final Date TIMESTAMP= new Date();
	private static final String STAFF = Order.getStaff();
	private static final int INVOICE_ID= invoices.size();
	double GROSS_PRICE = order.getTotal();
	double GST = GROSS_PRICE * GST_RATE;
	double SERVICE_CHARGE = GROSS_PRICE * SERVICE_CHARGE_RATE;
	double NET_PRICE= GROSS_PRICE+ GST + SERVICE_CHARGE;
	Invoice invoice = new Invoice(INVOICE_ID, TIMESTAMP, STAFF, order, GROSS_PRICE, GST, SERVICE_CHARGE, NET_PRICE);
	printInvoice(invoice);
}

public void printInvoice(Invoice invoice){
	invoice.print();
	
	
	
}





}