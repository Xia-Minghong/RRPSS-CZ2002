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

    @Override
    public void run() {
        showMenu();
    }

    private void showMenu() {
        System.out.println();
    }
}
