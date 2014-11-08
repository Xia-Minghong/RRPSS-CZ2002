package control;

import entity.Invoice;
import entity.Order;
import entity.Staff;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceManager {


    private OrderManager orderManager;

    private StaffManager staffManager;

    private ArrayList<Invoice> invoices;

    private final double GST_RATE;

    private final double SERVICE_CHARGE_RATE;

    private final String FILE_PATH;

    public InvoiceManager(OrderManager orderManager, StaffManager staffManager, double GST_RATE, double SERVICE_CHARGE_RATE, String FILE_PATH) {

        this.orderManager = orderManager;

        this.staffManager = staffManager;

        this.invoices = load();

        this.GST_RATE = GST_RATE;

        this.SERVICE_CHARGE_RATE = SERVICE_CHARGE_RATE;

        this.FILE_PATH = FILE_PATH;

    }

    private ArrayList<Invoice> load() {
        return (ArrayList<Invoice>) IOManager.read(FILE_PATH);
    }

    public void createInvoice(int orderID) {
        Order order = orderManager.getOrderbyID(orderID);
        Staff staff = staffManager.getStaffbyID(order.getStaffID());
        Date TIMESTAMP = new Date();
        String STAFF = Order.getStaff();
        int INVOICE_ID = invoices.size();
        double GROSS_PRICE = order.getTotal();
        double GST = GROSS_PRICE * GST_RATE;
        double SERVICE_CHARGE = GROSS_PRICE * SERVICE_CHARGE_RATE;
        double NET_PRICE = GROSS_PRICE + GST + SERVICE_CHARGE;
        Invoice invoice = new Invoice(INVOICE_ID, TIMESTAMP, STAFF, order, GROSS_PRICE, GST, SERVICE_CHARGE, NET_PRICE);
        printInvoice(invoice);
    }

    public void printInvoice(Invoice invoice) {
        invoice.print();


    }


}