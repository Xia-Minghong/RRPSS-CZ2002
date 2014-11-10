package control;

import entity.Table;

import java.util.ArrayList;

/**
 * The control class for table related logic / use cases
 *
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-11-8
 */
public class TableManager extends AbstractManager {

    /**
     * An ArrayList of tables holding the table instances to mimic the behavior of a database
     * Each query to this list is equivalent to a query to a database
     */
    private ArrayList<Table> tables;

    /**
     * Constructor of the TableManager class
     * @param FILE_PATH the file path from/to which the serialized stream of array list of tables is read/stored
     */
    public TableManager(String FILE_PATH) {
        super(FILE_PATH);
        this.tables = load();
    }

    /**
     * Perform the action of adding a table
     * @param capacity the capacity of the table to be added
     */
    public void addTable(int capacity) {
        tables.add(new Table(tables.size(), capacity));
    }

    /**
     * Get (the reference to) all the tables
     * @return (the reference to) all the tables
     */
    public ArrayList<Table> getTables() {
        return tables;
    }

    /**
     * Customized method to read the list of table instances from file
     * @return the list of table instances read from file or a new (empty) list of tables if no one is read
     */
    @Override
    public ArrayList<Table> load() {
        ArrayList<Table> tables = (ArrayList<Table>) read();
        if (tables == null) {
            tables = new ArrayList<Table>();
        }
        return tables;
    }

    /**
     * Customized method to write the list of table instances to file
     */
    @Override
    public void save() {
        write(tables);
    }
}
