package ProblemSet_8a;

import java.util.regex.Pattern;

public class Customer {
    private String name = null;
    private String surname = null;
    private static final String PATTERN = "^[A-Z][a-z]*";

    /**
     * Constructs a Customer object.
     *
     * @param name
     * @param surname
     * @throws IllegalArgumentException if name or surname doesn't match
     *                                  "^[A-Z][a-z]*" pattern
     */
    public Customer(String name, String surname)
            throws IllegalArgumentException {

        if (!this.validateInfo(name)) {
            throw new IllegalArgumentException("Badly formatted name");
        }
        if (!this.validateInfo(surname)) {
            throw new IllegalArgumentException("Badly formatted surname");
        }

        this.name = name;
        this.surname = surname;
    }

    /**
     * Outputs the initial for first name.
     *
     * @return the first character of the first name
     */
    public char getName() {
        return this.name.charAt(0);
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Check if the parameter supplied matches a regex.
     *
     * @param info
     * @return if info matches "^[A-Z][a-z]*" pattern
     */

    public boolean validateInfo(String info) {
        Pattern pattern = Pattern.compile(PATTERN);
        return pattern.matcher(info).matches();
    }

    @Override
    public String toString() {
        return String.format("%s. %s", this.getName(), this.surname);
    }
}
