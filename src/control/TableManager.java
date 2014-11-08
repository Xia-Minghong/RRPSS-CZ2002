package control;

import entity.Table;

import java.util.ArrayList;

/**
 * Created by root on 14-11-8.
 */
public class TableManager extends AbstractManager {

    private ArrayList<Table> tables;

    public TableManager(String FILE_PATH) {
        super(FILE_PATH);
        this.tables = load();
    }

    public void addTable(int capacity) {
        tables.add(new Table(tables.size(), capacity));
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    @Override
    public ArrayList<Table> load() {
        ArrayList<Table> tables = (ArrayList<Table>) read();
        if (tables == null) {
            tables = new ArrayList<Table>();
        }
        return tables;
    }

    @Override
    public void save() {
        write(tables);
    }
}
