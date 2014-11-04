import java.io.Serializable;

/**
 * Member is a model class which holds the relevant attributes
 * of a member and provides the mutators/setters and accessors/getters accordingly.
 */
public class Member implements Serializable{
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
     * @param name the name to be used in constructor
     * @param contact the contact number to be used in constructor
     */
    public Member(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    /**
     * Getter method for the member name
     * @return the name of the member
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the member name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the member contact
     * @return the contact number of the member
     */
    public String getContact() {
        return contact;
    }

    /**
     * Getter method for the member contact
     * @param contact contact number to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
}
