import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by root on 14-11-7.
 */
public class MemberBoundary {

    private ArrayList<Member> members;
    private MemberManager memberManager;

    public MemberBoundary(ArrayList<Member> members, MemberManager memberManager) {
        this.members = members;
        this.memberManager = memberManager;
    }

    public void run() {
        init();
        showMenu();
    }

    private void init() {
        memberManager.load();
    }

    private void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("choose what you want \n 1. Check Membership \n 2. List Members \n 3. Add Member \n 4.Delete Member ");

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
        Member member = memberManager.getMember(members, name);
        if (member != null) {
            System.out.println("Member detail:");
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
        memberManager.createMember(members, name, contact);
    }

    private void deleteMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The name of the member to delete");
        memberManager.deleteMember(members, sc.next());
    }

}
