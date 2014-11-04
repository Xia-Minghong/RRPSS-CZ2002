import java.util.Arrays;
import java.util.Date;

public class Invoice{

	private final int INVOICE_ID;

    private final Date TIMESTAMP;
	
	private final double GROSS_PRICE;
	
	private final double GST;
	
	private final double SERVICE_CHARGE;
	
	private final double NET_PRICE;


    /**
     *
     * @param INVOICE_ID
     * @param TIMESTAMP
     * @param GROSS_PRICE
     * @param GST
     * @param SERVICE_CHARGE
     * @param NET_PRICE
     */
    public Invoice(int INVOICE_ID, Date TIMESTAMP, double GROSS_PRICE, double GST, double SERVICE_CHARGE, double NET_PRICE) {
        this.INVOICE_ID = INVOICE_ID;        
        this.TIMESTAMP = TIMESTAMP;
        this.GROSS_PRICE = GROSS_PRICE;
        this.GST = GST;
        this.SERVICE_CHARGE = SERVICE_CHARGE;
        this.NET_PRICE = NET_PRICE;
    }
	
	public void printInvoice(){
		System.out.println("Invoice ID: %d", INVOICE_ID);
		System.out.println("Time: "+ TIMESTAMP);
/** not sure how to handle timestamp  */
		System.out.println(Arrays.toString(array));
		System.out.println("Gross Price: %f", GROSS_PRICE);
		System.out.println("GST: %f", GST);
		System.out.println("Service Charge: %f", SERVICE_CHARGE);
		System.out.println("Net Price: %f", NET_PRICE);	
}










}