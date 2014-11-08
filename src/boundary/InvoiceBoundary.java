package boundary;

import control.InvoiceManager;
import entity.Invoice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by root on 14-11-7.
 */
public class InvoiceBoundary implements Runnable {

    private ArrayList<Invoice> invoices;
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
            System.out.println("choose what you want \n 1. Check Membership \n 2. List Members \n 3. Add entity.Member \n 4.Delete entity.Member ");

            switch (sc.nextInt()) {
                case 1:
                    checkMembership();
                    break;
                case 2:
                    memberManager.printMembers();
                    break;
                case 3:
                    addMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                default:
                    return;
            }
        }
    }

    private void checkMembership() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The name to check for membership");
        String name = sc.next();
        Member member = memberManager.getMember(name);
        if (member != null) {
            System.out.println("entity.Member detail:");
            System.out.println(member);
        } else {
            System.out.println("Not a member");
        }
    }

    private void addMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The name of the member to add");
        String name = sc.next();
        System.out.println("The contact of the member to add");
        String contact = sc.next();
        memberManager.createMember(name, contact);
    }

    private void deleteMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The name of the member to delete");
        memberManager.deleteMember(sc.next());
    }

}
