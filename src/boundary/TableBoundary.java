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
    }


    private void showMenu() {
        System.out.println();
    }

    /**
     * Create tables if not
     */
    private void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Initializing Tables for the restaurant");
        do {


            System.out.println("Add more tables?");
        } while (scanner.next()=="y");
    }

    @Override
    public void run() {
        init();
        showMenu();
    }
}
