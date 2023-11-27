package ProblemSet_6a;

import java.util.regex.Pattern;

public class Supplier {
    private String name = null;

    private String phone = null;

    private static final String PATTERN = "^01483\\d{6}$";

    public Supplier(String name, String phone) throws IllegalArgumentException {
        super();
        Pattern pattern = Pattern.compile(PATTERN);
        if (!pattern.matcher(phone.replace("-", "")).matches()) {
            throw new IllegalArgumentException("Badly formatted phone number");
        }
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", this.name, this.phone);
    }
}
