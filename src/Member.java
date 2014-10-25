/**
 * Created by Xia-Minghong on 14-10-25.
 *
 * Member is a model class which holds the relevant attributes
 * of a member and provides the mutators/setters and accessors/getters accordingly.
 */
public class Member {
    /**
     * The name of the member
     */
    private String name;

    /**
     * The contact number of the member
     */
    private String contact;

    /**
     * Constructor of the Member class
     * @param name
     * @param contact
     */
    public Member(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    /**
     * Getter method for the member name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the member name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the member contact
     * @return
     */
    public String getContact() {
        return contact;
    }

    /**
     * Getter method for the member contact
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
}
