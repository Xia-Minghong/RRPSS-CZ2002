package entity;

import java.io.Serializable;

/**
 * entity.Table is a model class which holds the relevant attributes
 * of a table and provides the getters and setters accordingly.
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-10-24.
 */

public class Table implements Serializable{
    /**
     * The table ID of the table, immutable
     */
    private final int TABLE_ID;

    /**
     * The capacity of the table, immutable
     */
    private final int CAPACITY;

//    /**
//     * A indicator of whether the table is currently used by someone (physical presence)
//     * The default value is false (when constructed)
//     */
//    private boolean presence = false;

    /**
     * Constructor for the table
     * The presence attribute is always set to false when a table is constructed,
     * and true value is always set manually
     * @param TABLE_ID the table ID to be used in constructor
     * @param CAPACITY the capacity to be used in constructor
     */
    public Table(int TABLE_ID, int CAPACITY) {
        this.TABLE_ID = TABLE_ID;
        this.CAPACITY = CAPACITY;
    }

    /**
     * Getter method for the table ID
     * @return the ID of the table
     */
    public int getTABLE_ID() {
        return TABLE_ID;
    }

    /**
     * Getter method for the table capacity
     * @return the capacity of the table
     */
    public int getCAPACITY() {
        return CAPACITY;
    }

    @Override
    public String toString() {
        return "ID: " + TABLE_ID + "\tCapacity: " + CAPACITY;
    }

}
