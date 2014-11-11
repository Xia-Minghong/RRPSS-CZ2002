package boundary;

import control.InvoiceManager;
import entity.Invoice;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by root on 14-11-7.
 */
public class InvoiceBoundary implements Runnable {

    private InvoiceManager invoiceManager;

    public InvoiceBoundary(InvoiceManager invoiceManager) {
        this.invoiceManager = invoiceManager;
    }

    public void run() {
        showMenu();
    }


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
                dailyTotal += invoice.getNET_PRICE();
                System.out.println(invoice);
            }
        }

    }

    private void printMonthlyReport() {
        Invoice maxRevenueInvoice = null;
        Invoice minRevenueInvoice = null;
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

        int maxRevenueYear = maxRevenueInvoice.getTIMESTAMP().get(Calendar.YEAR);
        int maxRevenueMonth = maxRevenueInvoice.getTIMESTAMP().get(Calendar.MONTH);
        int maxRevenueDay = maxRevenueInvoice.getTIMESTAMP().get(Calendar.DAY_OF_MONTH);

//        String maxRevenueDate =

        int minRevenueYear = minRevenueInvoice.getTIMESTAMP().get(Calendar.YEAR);
        int minRevenueMonth = minRevenueInvoice.getTIMESTAMP().get(Calendar.MONTH);
        int minRevenueDay = minRevenueInvoice.getTIMESTAMP().get(Calendar.DAY_OF_MONTH);

//        String minRevenueDate = ;

    }

    private void addInvoice() {

        Scanner sc = new Scanner(System.in);
        int orderID = 0;
        boolean success;
        int testOrderID;
        do {
            success = true;
            System.out.println("Please enter the order id:");
            testOrderID = sc.nextInt();
            if(testOrderID == -1) break;
            for (Invoice invoice : invoiceManager.getInvoices()) {
                if (testOrderID == invoice.getOrderID()) {
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
