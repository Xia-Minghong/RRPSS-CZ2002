import java.util.ArrayList;

/**
 * Created by Xia-Minghong on 14-11-7.
 */
public class Restaurant {
    private ArrayList<Table> tables;
    private ArrayList<Staff> staffs;

    private String memberFilePath;

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public ArrayList<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(ArrayList<Staff> staffs) {
        this.staffs = staffs;
    }

    public String getMemberFilePath() {
        return memberFilePath;
    }

    public void setMemberFilePath(String memberFilePath) {
        this.memberFilePath = memberFilePath;
    }
}
