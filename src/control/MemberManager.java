package control;

import entity.Member;

import java.util.ArrayList;

/**
 * A control class for member related logic and actions
 *
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-11-4.
 */
public class MemberManager extends AbstractManager {


    /**
     * An ArrayList of members holding the member instances to mimic the behavior of a database
     * Each query to this list is equivalent to a query to a database
     */
    private ArrayList<Member> members;

    /**
     * Constructor of the control.MemberManager
     * During the construction, the path of the member data file is passed in.
     */
    public MemberManager(String FILE_PATH) {
        super(FILE_PATH);
        this.members = load();
    }

    /**
     * Create a new member and add into the member list
     *  @param name the name of the new member
     * @param contact the contact of the new member
     */
    public void createMember(String name, String contact) {
        Member newMember = new Member(name, contact);
        members.add(newMember);
    }

    /**
     * Get the member with the name given
     *
     * @param name the name of the member
     * @return the member with the name given
     */
    public Member getMember(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;  //if found
            }
        }
        return null; //if not fount
    }

    /**
     * Print a list of Members
     */
    public void printMembers() {
        System.out.println("Membership List:");
        System.out.println("Name\t\tContact");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    /**
     * Delete the member with the given name
     *
     * @param name the name of the member to be deleted
     */
    public void deleteMember(String name) {
        int index = -1;

        for (Member member : members) {
            if (member.getName().equals(name)) {
                index = members.indexOf(member);
                break;
            }
        }

        if (index != -1) {  //if the name exists in the members list
            System.out.println("deleting " + name + "...");
            members.remove(index);  //remove the record
            return;
        }
        System.out.println(name+" is not a member.");
    }

//    /**
//     * Load members data from file by interacting with control.IOManager
//     *
//     * @return a list of members if success null if failure
//     */
//    public ArrayList<Member> load() {
//        Object object = PersistentManager.read(FILE_PATH);
//        if (object instanceof ArrayList<?> && ((ArrayList<?>) object).get(0) instanceof Member) {
//            return (ArrayList<Member>) object;
//            //may generate a "uncheck cast" warning
//            //however it is checked inside the above if-statement
//        }
//        System.out.println("Error loading members from file");
//        return null;
//    }

    /**
     * Customized method to read the list of member instances from file
     * @return the list of member instances read from file or a new (empty) list of members if no one is read
     */
    @Override
    public ArrayList<Member> load() {
        ArrayList<Member> members = (ArrayList<Member>) read();
        if (members == null) {
            members = new ArrayList<Member>();
        }
        return members;
    }

    /**
     * Customized method to write the list of member instances to file
     */
    @Override
    public void save() {
        if (!write(members)) {
            System.out.println("Error saving members to file");
        }
    }


}


