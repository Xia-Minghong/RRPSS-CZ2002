package boundary;

import control.InvoiceManager;
import entity.Invoice;
import entity.Member;

import java.util.ArrayList;
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
                	System.out.print("Please enter the date(DD/MM/YYYY):");
                	dateStr = sc.next();
                	//dateStr = "11/11/2014";
                	date = dateStr.split("/");
	                checkDay= calTime.set(new Integer(date[2]), new Integer(date[1]) - 1,
           				new Integer(date[0],0,0));
                	printDay(checkDay);
                    break;
                case 3:
                	System.out.print("Please enter the date(MM/YYYY):");
                	dateStr = sc.next();
                	//dateStr = "11/2014";
                	date = dateStr.split("/");
	                checkMonth= calTime.set(0, new Integer(date[1]) - 1,
           				new Integer(date[0]),0,0);
                	printMonth(checkMonth);
                    break;
                
                
                default:
                    return;
            }
        }
    }


    private void addInvoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the order id:");
        int id_order = sc.nextInt();        
        invoiceManager.createInvoice(id_order);
    }

   

}
