package main.java.labs.Week_03;

public class User {
    private String name;

    private Email email;

    public User(String fullname, Email emailAddress) {
        super();
        this.name = fullname;
        this.email = emailAddress;
    }

    @Override
    public String toString() {
        return this.name + " <" + this.email.getEmailAddress() + ">";
    }
}
