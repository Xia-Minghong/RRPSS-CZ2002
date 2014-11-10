package boundary;

import control.TableManager;
import entity.Table;

import java.util.Scanner;

/**
 * The boundary class handling user interactions related to tables
 *
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-11-6
 */
public class TableBoundary implements Runnable {

    /**
     * The reference to a table control instance
     */
    private TableManager tableManager;

    /**
     * Constructor of the restaurant boundary class
     * which calls init() to initialize system variables if needed
     */
    public TableBoundary(TableManager tableManager) {
        this.tableManager = tableManager;
        init();
    }

    /**
     * Print the menu of actions that can be performed related to tables
     */
    private void showMenu() {
        System.out.println("Choose action:\n\t1. Add Tables\n\t2. Show tables\n\t3. Back");
    }

    /**
     * Create tables if there is not any
     */
    private void init() {
        if(tableManager.getTables().size()==0) {
            System.out.println("Initializing Tables for the restaurant");
            addTables();
        }
    }

    /**
     * Handles the user interactions about adding tables
     */
    private void addTables() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("\nTable "+tableManager.getTables().size()+" Capacity: ");
            int capacity = inputInteger();
            tableManager.addTable(capacity);
            System.out.print("Add more tables? ('y' to continue): ");
        } while (scanner.next().equals("y"));
    }

    /**
     * Entry point of this boundary
     */
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            int choice = inputInteger();
            switch (choice) {
                case 1:
                    addTables();
                    break;
                case 2:
                    showTables();
                case 3:
                    break;
            }
        } while (scanner.next().equals("y"));
    }

    /**
     * Show all the tables
     */
    private void showTables() {
        for (Table table : tableManager.getTables()) {
            System.out.println(table);
        }
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
