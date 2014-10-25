/**
 * Created by Xia-Minghong on 14-10-25.
 */
public class Member {
    private String name;
    private String contact;

    public Member(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
