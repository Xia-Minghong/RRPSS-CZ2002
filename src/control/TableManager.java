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

    @Override
    public void save() {
        write(tables);
    }
}
