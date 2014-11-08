package control;

import entity.Member;

import java.util.ArrayList;

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

    private ArrayList<Member> members;

    /**
     * Constructor of the control.MemberManager
     * During the construction, the path of the member data file is passed in.
     */
    public MemberManager(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
        this.members = loadMembers();
    }

    /**
     * Create a new member and add into the member list
     *  @param name    the name of the new member
     * @param contact the contact of the new member
     */
    public void createMember(String name, String contact) {
        Member newMember = new Member(name, contact);
        members.add(newMember);
    }

    /**
     * Get the member with the name given
     *
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
            members.remove(index);  //remove the record
        }
    }

    /**
     * Load members data from file by interacting with control.IOManager
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
    public void save() {
        if (!IOManager.write(members, FILE_PATH)) {
            System.out.println("Error saving members to file");
        }
    }


}


