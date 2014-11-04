public class InvoiceManager{

private int index;

private final double GST_RATE;

private final double SERVICE_CHARGE_RATE;

public InvoiceManager(int index, double GST_RATE, double SERVICE_CHARGE_RATE) {
           
    this.index = index;
  
    this.GST_RATE = GST_RATE;
    
    this.SERVICE_CHARGE_RATE = SERVICE_CHARGE_RATE;

}

public void createInvoice (int orderID){
	
	INVOICE_ID=index;
	
	order = OrderManager.getOrder(orderID);
	
	TIMESTAMP=order.getDate();
	
	GROSS_PRICE= order.getTotal();
	
	GST=GROSS_PRICE*0.07;
	
	SERVICE_CHARGE=GROSS_PRICE*0.1;
	
	NET_PRICE=GROSS_PRICE + GST + SERVICE_CHARGE;
	
	index++;
	return new Invoice(INVOICE_ID, TIMESTAMP, GROSS_PRICE, GST, SERVICE_CHARGE, NET_PRICE);
}






}