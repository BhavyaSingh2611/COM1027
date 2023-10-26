package ProblemSet_6a;

import java.util.regex.Pattern;

public class Supplier {
    private String name = null;

    private String phone = null;

    public Supplier(String name, String phone) throws IllegalArgumentException {
        super();
        Pattern pattern = Pattern.compile("01483\\d{6}");
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
        return String.format("%s <Phone: %s>", this.name, this.phone);
    }
}
