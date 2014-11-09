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
            System.out.println("choose what you want \n 1. Create Invoice ");

            switch (sc.nextInt()) {
                case 1:
                	addInvoice();
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
