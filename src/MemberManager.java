import java.util.ArrayList;

/**
 * A manager which takes the responsibilities of:
 *  1. getting members data from file
 *  2. Writing members data to file
 *  3. Handle the creation/deletion of a member
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-11-4.
 */
public class MemberManager {

    /**
     * The list of members
     */
    private static ArrayList<Member> members;

    /**
     * the file path from which the member list is read
     * and to which the member list is written
     */
    private static final String FILE_PATH = "members.dat";

    /**
     * Constructor of the MemberManager
     * During the construction, members data is read from file and
     * the members list is initialized.
     */
    public MemberManager() {
        members = loadMembers();
    }

    /**
     * Create a new member and add into the member list
     * @param name the name of the new member
     * @param contact the contact of the new member
     */
    public void createMember(String name, String contact) {
        Member newMember = new Member(name, contact);
        members.add(newMember);
    }

    /**
     * Load members data from file by interacting with IOManager
     * @return a list of members if success null if failure
     */
    private ArrayList<Member> loadMembers() {
        Object object = IOManager.read(FILE_PATH);
        if (object instanceof ArrayList<?> && ((ArrayList<?>) object).get(0) instanceof Member) {
            return (ArrayList<Member>) object;
            //may generate a "uncheck cast" warning
            //however it is checked inside the above if-statement
        }
        System.out.println("Error loading members from file");
        return null;
    }

    /**
     * Save the member list into file
     */
    public void saveMembers() {
        if (!IOManager.write(members, FILE_PATH)) {
            System.out.println("Error saving members to file");
        }
    }
}
