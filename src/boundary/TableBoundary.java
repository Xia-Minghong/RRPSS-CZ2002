package boundary;

import control.TableManager;

import java.util.Scanner;

/**
 * Created by root on 14-11-8.
 */
public class TableBoundary implements Runnable {

    private TableManager tableManager;

    public TableBoundary(TableManager tableManager) {
        this.tableManager = tableManager;
        init();
    }


    private void showMenu() {
        System.out.println("Choose acion:\n\t1. Add Tables\n\t2. Back");
    }

    /**
     * Create tables if not
     */
    private void init() {
        if(tableManager.getTables().size()==0) {
            System.out.println("Initializing Tables for the restaurant");
            addTables();
        }
    }

    private void addTables() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("\nTable "+tableManager.getTables().size()+" Capacity: ");
            int capacity = scanner.nextInt();
            tableManager.addTable(capacity);
            System.out.print("Add more tables? ('y' to continue): ");
        } while (scanner.next()=="y");
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            switch (scanner.nextInt()) {
                case 1:
                    addTables();
                    break;
                case 2:
                    break;
            }
        } while (scanner.next() == "y");
    }
}
