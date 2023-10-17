package main.java.labs.Week_03;

public class Email {
    private final String DEFAULT_ADDRESS = "unknown@unknown";

    private String emailAddress = DEFAULT_ADDRESS;

    public Email(String email) {
        super();
        this.emailAddress = email;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
