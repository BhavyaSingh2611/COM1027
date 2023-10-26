package ProblemSet_8a;

import java.util.regex.Pattern;

public class Customer {
    private String name;
    private String surname;
    private static final String PATTERN = "^[A-Z][a-z]*";
    public Customer(String name, String surname)
            throws IllegalArgumentException {

        if (!this.validateInfo(name) && !this.validateInfo(surname)) {
            throw new IllegalArgumentException("Badly formatted name");
        }

        this.name = name;
        this.surname = surname;
    }

    public char getName() {
        return this.name.charAt(0);
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean validateInfo(String info) {
        Pattern pattern = Pattern.compile(PATTERN);
        return pattern.matcher(info).matches();
    }

    @Override
    public String toString() {
        return String.format("%s. %s", this.getName(), this.surname);
    }
}
