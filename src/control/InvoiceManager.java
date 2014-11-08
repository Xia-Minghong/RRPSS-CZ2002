package control;

import entity.Invoice;
import entity.Order;

import java.util.ArrayList;

public class InvoiceManager{

private int index;

private final double GST_RATE;

private final double SERVICE_CHARGE_RATE;

private ArrayList<Invoice> invoices;

public InvoiceManager(ArrayList<Invoice> invoices, int index, double GST_RATE, double SERVICE_CHARGE_RATE) {
           
	this.invoices = invoices;
	
    this.index = index;
  
    this.GST_RATE = GST_RATE;
    
    this.SERVICE_CHARGE_RATE = SERVICE_CHARGE_RATE;

}

public void createInvoice(int orderID){
	Order order = OrderManager.getOrderbyID(orderID);
	double GROSS_PRICE = order.getTotal(orderID);
	double GST = GROSS_PRICE * GST_RATE;
	double GST = SERVICE_CHARGE * SERVICE_CHARGE_RATE;
	double NET_PRICE= GROSS_PRICE+ GST + SERVICE_CHARGE;
	Invoice invoice = new Invoice();
	printInvoice(invoice);
}

public void printInvoice(Invoice invoice){
	invoice.print();
	
	
	
}





}