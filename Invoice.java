import java.util.Arrays;

public class Invoice{

	private final int INVOICE_ID;
	
	private final Date TIMESTAMP;
	
	private final double GROSS_PRICE;
	
	private final double GST;
	
	private final double SERVICE_CHARGE;
	
	private final double NET_PRICE;
	
	public static int count=0;
	
	public void printInvoice(){
		System.out.println("Invoice ID: %d", INVOICE_ID);
		System.out.println("Time:"TIMESTAMP);
/** not sure how to handle timestamp  */
		System.out.println(Arrays.toString(array));
		System.out.println("Gross Price: %f", GROSS_PRICE);
		System.out.println("GST: %f", GST);
		System.out.println("Service Charge: %f", SERVICE_CHARGE);
		System.out.println("Net Price: %f", NET_PRICE);	
}










}