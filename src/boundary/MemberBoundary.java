package boundary;

import control.MemberManager;
import entity.Member;

import java.util.Scanner;

/**
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-11-6
 */
public class MemberBoundary implements Runnable{

    private MemberManager memberManager;

    public MemberBoundary(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void run() {
        showMenu();
    }

    private void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("choose what you want \n 1. Check Membership \n 2. List Members \n 3. Add entity.Member \n 4.Delete entity.Member ");

            switch (sc.nextInt()) {
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

    private void checkMembership() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The name to check for membership");
        String name = sc.next();
        Member member = memberManager.getMember(name);
        if (member != null) {
            System.out.println("entity.Member detail:");
            System.out.println(member);
        } else {
            System.out.println("Not a member");
        }
    }

    private void addMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The name of the member to add");
        String name = sc.next();
        System.out.println("The contact of the member to add");
        String contact = sc.next();
        memberManager.createMember(name, contact);
        System.out.println("New member added.");
    }

    private void deleteMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The name of the member to delete");
        memberManager.deleteMember(sc.next());
    }

}
