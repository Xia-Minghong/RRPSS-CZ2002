package boundary;

import control.InvoiceManager;
import entity.Invoice;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 
 * @author Brian
 *
 */
public class InvoiceBoundary implements Runnable {
/**
 * 
 */
    private InvoiceManager invoiceManager;
/**
 * 
 * @param invoiceManager
 */
    public InvoiceBoundary(InvoiceManager invoiceManager) {
        this.invoiceManager = invoiceManager;
    }
/**
 * 
 */
    public void run() {
        showMenu();
    }

/**
 * 
 */
    private void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("choose what you want \n 1. Create Invoice \n 2. Print Daily Report \n 3. Print Monthly Report \n 4. Back  ");

            switch (sc.nextInt()) {
                case 1:
                    addInvoice();
                    break;
                case 2:
                    printDailyReport();
                    break;
                case 3:
                    printMonthlyReport();
                    break;


                default:
                    return;
            }
        }
    }
/**
 * 
 */
    private void printDailyReport() {
        double dailyTotal = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the date(DD/MM/YYYY):");
        String dateStr = sc.next();
        //dateStr = "11/11/2014";
        String[] date = dateStr.split("/");
        int day = Integer.parseInt(date[2]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[0]);

        for (Invoice invoice : invoiceManager.getInvoices()) {
            int invoice_d = invoice.getTIMESTAMP().get(Calendar.DAY_OF_MONTH);
            int invoice_m = invoice.getTIMESTAMP().get(Calendar.MONTH) + 1;
            int invoice_y = invoice.getTIMESTAMP().get(Calendar.YEAR);
            

            if (invoice_d == day && invoice_m == month && invoice_y == year) {
            	invoiceManager.printInvoice(invoice);
            	dailyTotal += invoice.getNET_PRICE();
            }
            
            
        }
        
        System.out.println("Total for the day is $" + dailyTotal);
    }
/**
 * 
 */
    private void printMonthlyReport() {
        Invoice maxRevenueInvoice = null;
        Invoice minRevenueInvoice = null;
        int maxRevenueDay=0;
        int maxRevenueMonth=0;
        int maxRevenueYear=0;
        int minRevenueDay=0;
        int minRevenueMonth=0;
        int minRevenueYear=0;
        double totalRevenue = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the date(MM/YYYY):");
        String dateStr = sc.next();
        //dateStr = "11/2014";
        String[] date = dateStr.split("/");

        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[0]);

        for (Invoice invoice : invoiceManager.getInvoices()) {

            int invoice_m = invoice.getTIMESTAMP().get(Calendar.MONTH) + 1;
            int invoice_y = invoice.getTIMESTAMP().get(Calendar.YEAR);

            if (invoice_m == month && invoice_y == year) {
                if (minRevenueInvoice == null)
                    minRevenueInvoice = invoice;
                if (maxRevenueInvoice == null)
                    maxRevenueInvoice = invoice;
                if (invoice.getNET_PRICE() < minRevenueInvoice.getNET_PRICE())
                    minRevenueInvoice = invoice;
                if (invoice.getNET_PRICE() > maxRevenueInvoice.getNET_PRICE())
                    maxRevenueInvoice = invoice;

                totalRevenue += invoice.getNET_PRICE();
            }
        }
        if (maxRevenueInvoice== null){
        	System.out.println("No invoices for the month.");
        	System.out.println("Total Revenue = $0");}
        else
        {
        	maxRevenueYear = maxRevenueInvoice.getTIMESTAMP().get(Calendar.YEAR);
        	maxRevenueMonth = maxRevenueInvoice.getTIMESTAMP().get(Calendar.MONTH);
        	maxRevenueDay = maxRevenueInvoice.getTIMESTAMP().get(Calendar.DAY_OF_MONTH);

//        String maxRevenueDate =

        	minRevenueYear = minRevenueInvoice.getTIMESTAMP().get(Calendar.YEAR);
        	minRevenueMonth = minRevenueInvoice.getTIMESTAMP().get(Calendar.MONTH);
        	minRevenueDay = minRevenueInvoice.getTIMESTAMP().get(Calendar.DAY_OF_MONTH);

//        String minRevenueDate = Integer.toString(minRevenueDay);
        	System.out.println("Total Revenue for the month is " + totalRevenue);
            System.out.println("Highest revenue is $" + maxRevenueInvoice.getNET_PRICE()+" on " + minRevenueDay +"/" + minRevenueMonth + "/"+ minRevenueYear);
            System.out.println("Lowest revenue is $" + minRevenueInvoice.getNET_PRICE()+" on " + minRevenueDay +"/" + minRevenueMonth + "/"+ minRevenueYear);
        
        }
    
        
    }
    
/**
 * 
 */
    private void addInvoice() {

        Scanner sc = new Scanner(System.in);
        int orderID = 0;
        boolean success;
        int testOrderID;
        
        do {
            success = true;
            System.out.println("Please enter the order id (enter -1 to exit):");
            testOrderID = sc.nextInt();
            if(testOrderID == -1) break;
            for (Invoice invoice : invoiceManager.getInvoices()) {
                if (invoiceManager.checkOrderByID(testOrderID) != null && testOrderID == invoice.getOrderID()) {
                    success = false;
                    break;
                }
            }
        } while (!success);
        orderID = testOrderID;
        if (orderID == -1) {
            System.out.println("exit");
            return;
        }

        System.out.println("Enter name of the customer (check membership)");
        sc.nextLine();
        String name = sc.nextLine();

        invoiceManager.createInvoice(orderID, name);
    }


}
