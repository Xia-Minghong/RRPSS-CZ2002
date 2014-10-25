import java.io.Serializable;

/**
 * Created by Xia-Minghong on 14-10-25.
 *
 * Table is a model class which holds the relevant attributes
 * of a table and provides the mutators and accessors accordingly.
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

    /**
     * A indicator of whether the table is currently used by someone (physical presence)
     * The default value is false (when constructed)
     */
    private boolean presence = false;

    /**
     * Constructor for the table
     * The presence attribute is always set to false when a table is constructed,
     * and true value is always set manually
     * @param TABLE_ID
     * @param CAPACITY
     */
    public Table(int TABLE_ID, int CAPACITY) {
        this.TABLE_ID = TABLE_ID;
        this.CAPACITY = CAPACITY;
    }

    /**
     * Getter method for the table ID
     * @return
     */
    public int getTABLE_ID() {
        return TABLE_ID;
    }

    /**
     * Getter method for the table capacity
     * @return
     */
    public int getCAPACITY() {
        return CAPACITY;
    }

    /**
     * Getter method for the occupation state of the table
     * @return
     */
    public boolean isPresence() {
        return presence;
    }

    /**
     * Setter method for the occupation state of the table
     * @param presence
     */
    public void setPresence(boolean presence) {
        this.presence = presence;
    }
}
