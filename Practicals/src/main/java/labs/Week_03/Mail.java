package main.java.labs.Week_03;

public class Mail {
    private User sender;
    private User recipient;
    private String message;

    public Mail(User sender, User recipient, String message) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
    }

    public String getSender() {
        return this.sender.toString();
    }

    public User getRecipient() {
        return this.recipient;
    }

    public String getMessage() {
        return message;
    }

    public void print() {
        System.out.println("From: " + getSender());
        System.out.println("To: " + getRecipient());
        this.isEmpty();
        System.out.println("Message: " + this.message);

    }


    private void isEmpty() {
        if (this.getMessage() == null || this.getMessage().isEmpty()) {
            this.message = "** Something went wrong! **";
        }
    }
}
