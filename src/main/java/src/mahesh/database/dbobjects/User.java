package src.mahesh.database.dbobjects;

/**
 * Created by mahesh on 5/18/17.
 */
public class User {
    private String firstName;
    private String lastName;
    private String middleName;
    private String username;

    public User (String fname, String lname, String mname, String username) {
        this.firstName = fname;
        this.lastName = lname;
        this.middleName = mname;
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
