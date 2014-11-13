package control;

import entity.Invoice;
import entity.Order;
import entity.Staff;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @author Wong Chun Keet
 *
 */
public class InvoiceManager extends AbstractManager {
	

/**
 * provides access to order to get details of order 
 */
    private OrderManager orderManager;
/**
 * provides access to member to check membership
 */
    private MemberManager memberManager;
/**
 * provides access to restaurant to get member discount rate and gst and service charge
 */
    private RestaurantManager restaurantManager;
/**
 * provides access to reservation to delete reservation when customer pays the bill
 */
    private ReservationManager reservationManager;
/**
 * holds all the invoices created
 */
    private ArrayList<Invoice> invoices;
/**
 * the gst rate applied on the gross price
 */
    private final double GST_RATE;
/**
 * the service charge applied on the gross price
 */
    private final double SERVICE_CHARGE_RATE;
    
    /**
     * 
     * @param orderManager instance of OrderManager
     * @param restaurantManager instance of RestaurantManager
     * @param memberManager instance of MemberManager
     * @param reservationManager instance of ReservationManager
     * @param FILE_PATH for file input and output
     */
    public InvoiceManager(OrderManager orderManager, RestaurantManager restaurantManager, MemberManager memberManager, ReservationManager reservationManager, String FILE_PATH) {

        super(FILE_PATH);

        this.orderManager = orderManager;

        this.restaurantManager = restaurantManager;
        
        this.memberManager = memberManager;
        
        this.reservationManager = reservationManager;

        this.invoices = load();

        this.GST_RATE = restaurantManager.getRestaurant().getGSTRate();

        this.SERVICE_CHARGE_RATE = restaurantManager.getRestaurant().getServiceChargeRate();
        
        
    }
/**
 * receives input of orderID and customer name
 * check if customer is member
 * calculate the gross price of the bill less discount if customer is member, and the gst, service charge and net price
 * @param orderID is the serial number of the order being paid for
 * @param name is the name of the customer paying the bill to check for membership
 */
    public boolean createInvoice(int orderID, String name) {

        Order order = orderManager.getOrderbyID(orderID);
        String staffName = order.getStaff().getStaffName();
        String restaurantName = restaurantManager.getRestaurantName();
        int tableNo = order.getTableID();
        Calendar TIMESTAMP = Calendar.getInstance();
        TIMESTAMP.setTime(new Date());
//        String STAFF = order.getStaff();
        int INVOICE_ID = invoices.size();
        double GROSS_PRICE = order.getTotal();
        if (memberManager.getMember(name) != null) {
            System.out.println(name + " is a member.");
            GROSS_PRICE *= restaurantManager.getMembershipDiscountRate();
        } else {
            System.out.println(name + " not a member.");
        }

        double GST = GROSS_PRICE * GST_RATE;
        double SERVICE_CHARGE = GROSS_PRICE * SERVICE_CHARGE_RATE;
        double NET_PRICE = GROSS_PRICE + GST + SERVICE_CHARGE;
        Invoice invoice = new Invoice(restaurantName, INVOICE_ID, orderID, TIMESTAMP, staffName, order, GROSS_PRICE, GST, SERVICE_CHARGE, NET_PRICE);

        invoices.add(invoice);
        printInvoice(invoice);
        reservationManager.checkOut(tableNo);
        return true;
    }
/**
 * prints invoice by passing in created invoice instance
 * @param invoice is the instance of invoice
 */
    public void printInvoice(Invoice invoice) {
        System.out.println(invoice);
    }
/**
 * append the invoice to the arraylist of invoices for future reference
 */
    @Override
    public ArrayList<Invoice> load() {
        ArrayList<Invoice> invoices = (ArrayList<Invoice>) read();
        if (invoices == null) {
            invoices = new ArrayList<Invoice>();
        }
        return invoices;
    }
/**
 * write the created invoices into external file
 */
    @Override
    public void save() {
        write(invoices);
    }

/**
 * access tHe list of invoices created so far
 * @return tHe invoices saved
 */
    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }
   /**
    *access order by its serial number
    * @param checkID
    * @return tHe order accordinG to tHe serial number of order
    */
    public Order checkOrderByID(int checkID){

    	return orderManager.getOrderbyID(checkID);
    }
}