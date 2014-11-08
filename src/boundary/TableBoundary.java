package boundary;

import control.TableManager;

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
        System.out.println("");
    }

    @Override
    public void run() {
        init();
        showMenu();
    }
}
