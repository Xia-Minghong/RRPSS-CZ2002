import java.util.ArrayList;

/**
 * Created by root on 14-11-4.
 */
public class MemberManager {
    private static ArrayList<Member> members;
    private static final String FILE_PATH = "members.dat";
    public MemberManager() {
        members = loadMembers();
    }

    public void createMember(String name, String contact) {
        Member newMember = new Member(name, contact);
        members.add(newMember);
    }

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

    public void saveMembers() {
        if (!IOManager.write(members, FILE_PATH)) {
            System.out.println("Error saving members to file");
        }
    }
}
