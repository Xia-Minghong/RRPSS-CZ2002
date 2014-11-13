package boundary;

import control.InvoiceManager;
import entity.Invoice;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

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

        int maxRevenueDay=0;

        int minRevenueDay=0;

        double totalRevenue = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the date(MM/YYYY):");
        String dateStr = sc.next();
        //dateStr = "11/2014";
        String[] date = dateStr.split("/");

        int month = Integer.parseInt(date[0]);
        int year = Integer.parseInt(date[1]);

        Calendar cal = new GregorianCalendar(year, month - 1, 1);
        int length = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        double[] revenues = new double[length];
        for (int i = 0; i < length; i++) {
            revenues[i] = 0;
        }

        for (Invoice invoice : invoiceManager.getInvoices()) {

            int invoice_d = invoice.getTIMESTAMP().get(Calendar.DAY_OF_MONTH)-1;
            int invoice_m = invoice.getTIMESTAMP().get(Calendar.MONTH);
            int invoice_y = invoice.getTIMESTAMP().get(Calendar.YEAR);

            if (invoice_m == month-1 && invoice_y == year) {
//                if (minRevenueInvoice == null)
//                    minRevenueInvoice = invoice;
//                if (maxRevenueInvoice == null)
//                    maxRevenueInvoice = invoice;
//                if (invoice.getNET_PRICE() < minRevenueInvoice.getNET_PRICE())
//                    minRevenueInvoice = invoice;
//                if (invoice.getNET_PRICE() > maxRevenueInvoice.getNET_PRICE())
//                    maxRevenueInvoice = invoice;
                revenues[invoice_d]+=invoice.getNET_PRICE();

                totalRevenue += invoice.getNET_PRICE();
            }
        }
//        if (maxRevenueInvoice== null){
//        	System.out.println("No invoices for the month.");
//        	System.out.println("Total Revenue = $0");}
//        else
//        {
//        	maxRevenueYear = maxRevenueInvoice.getTIMESTAMP().get(Calendar.YEAR);
//        	maxRevenueMonth = maxRevenueInvoice.getTIMESTAMP().get(Calendar.MONTH)+1;
//        	maxRevenueDay = maxRevenueInvoice.getTIMESTAMP().get(Calendar.DAY_OF_MONTH)+1;
//
////        String maxRevenueDate =
//
//        	minRevenueYear = minRevenueInvoice.getTIMESTAMP().get(Calendar.YEAR);
//        	minRevenueMonth = minRevenueInvoice.getTIMESTAMP().get(Calendar.MONTH)+1;
//        	minRevenueDay = minRevenueInvoice.getTIMESTAMP().get(Calendar.DAY_OF_MONTH)+1;

//        String minRevenueDate = Integer.toString(minRevenueDay);

        double maxRevenue = 0;
        double minRevenue = -1;
        for (int i = 0; i < length; i++) {
            if (revenues[i] > maxRevenue) {
                maxRevenue = revenues[i];
                maxRevenueDay = i+1;
            }
            if (revenues[i] < minRevenue || minRevenue < 0) {
                minRevenue = revenues[i];
                minRevenueDay = i+1;
            }
        }
        System.out.println("Total Revenue for the month is " + totalRevenue);
            System.out.println("Highest revenue is $" + maxRevenue+" on " + maxRevenueDay +"/" + month + "/"+ year);
            System.out.println("Lowest revenue is $" + minRevenue+" on " + minRevenueDay +"/" + month + "/"+ year);
        
//        }
    
        
    }
    
/**
 * 
 */
    private void addInvoice() {

        Scanner sc = new Scanner(System.in);
        int orderID;
        boolean success;
        int testOrderID;

        do {
            success = true;
            System.out.println("Please enter the order id (enter -1 to exit):");
            testOrderID = inputInteger();
            if(testOrderID == -1) break;
            try {
                invoiceManager.checkOrderByID(testOrderID);
            } catch (IndexOutOfBoundsException e) {
                success = false;
                System.out.println("Invalid Order ID");
                continue;
            }
            for (Invoice invoice : invoiceManager.getInvoices()) {
                if (testOrderID == invoice.getOrderID()) {
                    System.out.println("Order already checked out");
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
        String name = sc.nextLine();

        invoiceManager.createInvoice(orderID, name);
    }

    /**
     * Repeatedly asking for an integer input from System.in until getting one
     * @return the integer got from the input
     */
    private int inputInteger() {
        int integer;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.next();
                integer = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ne) {    //handle invalid input
                System.out.print("Not an integer, type again: ");
            }
        }
        return integer;
    }

}
