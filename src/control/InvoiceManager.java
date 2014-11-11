package control;

import entity.Invoice;
import entity.Order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class InvoiceManager extends AbstractManager {


    private OrderManager orderManager;

    private StaffManager staffManager;
    
    private MemberManager memberManager;

    private RestaurantManager restaurantManager;

    private ArrayList<Invoice> invoices;

    private final double GST_RATE;

    private final double SERVICE_CHARGE_RATE;
    
    
    public InvoiceManager(OrderManager orderManager, StaffManager staffManager, RestaurantManager restaurantManager, MemberManager memberManager, String FILE_PATH) {

        super(FILE_PATH);

        this.orderManager = orderManager;

        this.staffManager = staffManager;
        
        this.restaurantManager = restaurantManager;
        
        this.memberManager = memberManager;

        this.invoices = load();

        this.GST_RATE = restaurantManager.getRestaurant().getGSTRate();

        this.SERVICE_CHARGE_RATE = restaurantManager.getRestaurant().getServiceChargeRate();
        
        
    }

    public void createInvoice(int orderID, String name) {
        Order order = orderManager.getOrderbyID(orderID);
        String staffName = staffManager.getStaffbyID(order.getStaff().getStaffID()).getStaffName();
        Calendar TIMESTAMP = Calendar.getInstance();
        TIMESTAMP.setTime(new Date());
//        String STAFF = order.getStaff();
        int INVOICE_ID = invoices.size();
        double GROSS_PRICE = order.getTotal();
        if (memberManager.getMember(name) != null) {
            GROSS_PRICE *= restaurantManager.getMembershipDiscountRate();
        }

        double GST = GROSS_PRICE * GST_RATE;
        double SERVICE_CHARGE = GROSS_PRICE * SERVICE_CHARGE_RATE;
        double NET_PRICE = GROSS_PRICE + GST + SERVICE_CHARGE;
        Invoice invoice = new Invoice(INVOICE_ID, TIMESTAMP, staffName, order, GROSS_PRICE, GST, SERVICE_CHARGE, NET_PRICE);
        printInvoice(invoice);
    }

    public void printInvoice(Invoice invoice) {
        invoice.print();


    }

    @Override
    public ArrayList<Invoice> load() {
        ArrayList<Invoice> invoices = (ArrayList<Invoice>) read();
        if (invoices == null) {
            invoices = new ArrayList<Invoice>();
        }
        return invoices;
    }

    @Override
    public void save() {
        write(invoices);
    }


    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }
}