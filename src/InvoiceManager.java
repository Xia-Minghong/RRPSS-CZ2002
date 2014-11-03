public class InvoiceManager{

public void createInvoice (int orderID){
	this.INVOICE_ID = Invoice.count; 
	
	java.util.Date date= new java.util.Date();
	this.TIMESTAMP= date;
	
	this.GROSS_PRICE= Order.getTotal(orderID);
	
	this.GST= GROSS_PRICE*0.07;
	
	this.SERVICE_CHARGE=GROSS_PRICE*0.1;
	
	this.NET_PRICE=GROSS_PRICE+GST+SERVICE_CHARGE;	
		
	count ++;
}






}