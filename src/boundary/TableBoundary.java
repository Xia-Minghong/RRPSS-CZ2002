package boundary;

import control.TableManager;
import entity.Table;

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
        System.out.println("Choose acion:\n\t1. Add Tables\n\t2. Show tables\n\t3. Back");
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
            int capacity = inputInteger();
            tableManager.addTable(capacity);
            System.out.print("Add more tables? ('y' to continue): ");
        } while (scanner.next().equals("y"));
    }

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

    private void showTables() {
        for (Table table : tableManager.getTables()) {
            System.out.println(table);
        }
    }

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
