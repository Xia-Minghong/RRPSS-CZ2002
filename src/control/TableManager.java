package control;

import entity.Table;

import java.util.ArrayList;

/**
 * Created by root on 14-11-8.
 */
public class TableManager extends PersistentManager{

    private ArrayList<Table> tables;

    public TableManager(String FILE_PATH) {
        super(FILE_PATH);
        this.tables = (ArrayList<Table>) read();
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    @Override
    public void save() {
        write(tables);
    }
}
