import java.util.ArrayList;
import java.util.Scanner;

/**
 * A manager which takes the responsibilities of:
 *  1. getting/Writing members data from/to file
 *  2. Handle the creation/deletion of a member
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-11-4.
 */
public class MemberManager {

    /**
     * the file path from which the member list is read
     * and to which the member list is written
     */
    private final String FILE_PATH;

    /**
     * Constructor of the MemberManager
     * During the construction, the path of the member data file is passed in.
     */
    public MemberManager(ArrayList<Member> members, String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

    /**
     * Create a new member and add into the member list
     *
     * @param members ArrayList of members
     * @param name    the name of the new member
     * @param contact the contact of the new member
     */
    public void createMember(ArrayList<Member> members, String name, String contact) {
        Member newMember = new Member(name, contact);
        members.add(newMember);
    }

    /**
     * Get the member with the name given
     *
     *
     * @param members ArrayList of members
     * @param name the name of the member
     * @return the member with the name given
     */
    public Member getMember(ArrayList<Member> members, String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;  //if found
            }
        }
        return null; //if not fount
    }

    /**
     * Print a list of Members
     * @param members ArrayList of members
     */
    public void printMembers(ArrayList<Member> members) {
        System.out.println("Membership List:");
        System.out.println("Name\t\tContact");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    /**
     * Delete the member with the given name
     *
     * @param members ArrayList of members
     * @param name the name of the member to be deleted
     */
    public void deleteMember(ArrayList<Member> members, String name) {
        int index = -1;

        for (Member member : members) {
            if (member.getName().equals(name)) {
                index = members.indexOf(member);
                break;
            }
        }

        if (index != -1) {  //if the name exists in the members list
            members.remove(index);  //remove the record
        }
    }

    /**
     * Load members data from file by interacting with IOManager
     *
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
    public void saveMembers(ArrayList<Member> members) {
        if (!IOManager.write(members, FILE_PATH)) {
            System.out.println("Error saving members to file");
        }
    }

    public void run(ArrayList<Member> members) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("choose what you want \n 1. Check Membership \n 2. List Members \n 3. Add Member \n 4.Delete Member ");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("The name to check for membership");
                    Member member = getMember(members, sc.next());
                    if (member != null) {
                        System.out.println("Member detail:");
                        System.out.println(member);
                    } else {
                        System.out.println("Not a member");
                    }
                    break;
                case 2:
                    printMembers(members);
                    break;
                case 3:
                    System.out.println("The name of the member to add");
                    String name = sc.next();
                    System.out.println("The contact of the member to add");
                    String contact = sc.next();
                    createMember(members, name, contact);
                    break;
                case 4:
                    System.out.println("The name of the member to delete");
                    deleteMember(members, sc.next());
                    break;
                default:
                    return;
            }
        }
    }
}


