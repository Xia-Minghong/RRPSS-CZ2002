import java.io.Serializable;

/**
 * Created by Xia-Minghong on 14-10-25.
 */

public class Table implements Serializable{
    private final int TABLE_ID;
    private final int CAPACITY;
    private boolean presence = false;

    public Table(int TABLE_ID, int CAPACITY) {
        this.TABLE_ID = TABLE_ID;
        this.CAPACITY = CAPACITY;
    }

    public int getTABLE_ID() {
        return TABLE_ID;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }
}
