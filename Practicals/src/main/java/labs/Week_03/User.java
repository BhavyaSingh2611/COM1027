package main.java.labs.Week_03;

public class User {
    private String name;

    private Email email;

    @Override
    public String toString() {
        return this.name + " <" + this.email.getEmailAddress() + ">";
    }
}
