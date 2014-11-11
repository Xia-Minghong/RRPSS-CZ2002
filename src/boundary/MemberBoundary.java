package boundary;

import control.MemberManager;
import entity.Member;

import java.util.Scanner;

/**
 * The boundary class handling user interactions related to members
 *
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-11-6
 */
public class MemberBoundary implements Runnable{

    /**
     * The reference to the member control instance
     */
    private MemberManager memberManager;

    /**
     * Constructor of the MemberBoundary class
     * @param memberManager the reference to the member manager instance
     */
    public MemberBoundary(MemberManager memberManager) {
        this.memberManager = memberManager;
    }


    private void showMenu() {
        System.out.println("choose what you want \n 1. Check Membership \n 2. List Members \n 3. Add Member \n 4. Delete Member \n 5. Go back");
    }

    /**
     * The entry point of the member boundary
     */
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice;
            while (true) {
                showMenu();
                try {
                    String input = sc.next();
                    choice = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException ne) {    //handle invalid input
                    System.out.print("Invalid choice, choose again: ");
                }
            }
            switch (choice) {
                case 1:
                    checkMembership();
                    break;
                case 2:
                    memberManager.printMembers();
                    break;
                case 3:
                    addMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                default:
                    return;
            }
        }
    }

    /**
     * A method that handles the user interactions related to membership checking
     */
    private void checkMembership() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The name to check for membership");
        String name = sc.next();
        Member member = memberManager.getMember(name);
        if (member != null) {
            System.out.println("Member detail:");
            System.out.println(member);
        } else {
            System.out.println("Not a member");
        }
    }

    /**
     * A method that handles the user interactions related to adding a member
     */
    private void addMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The name of the member to add");
        String name = sc.next();
        System.out.println("The contact of the member to add");
        String contact = sc.next();
        memberManager.createMember(name, contact);
        System.out.println("New member added.");
    }

    /**
     * A method that handles the user interactions related to deleting a member
     */
    private void deleteMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The name of the member to delete");
        memberManager.deleteMember(sc.next());
    }

}
