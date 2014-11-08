package control;

import entity.Table;

import java.util.ArrayList;

/**
 * Created by root on 14-11-8.
 */
public class TableManager {

    private ArrayList<Table> tables;

    private final String FILE_PATH;

    public TableManager(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
        this.tables = load();
    }

    private ArrayList<Table> load() {
        return (ArrayList<Table>) IOManager.read(FILE_PATH);
    }

    private void save() {
        IOManager.write(tables, FILE_PATH);
    }
}
