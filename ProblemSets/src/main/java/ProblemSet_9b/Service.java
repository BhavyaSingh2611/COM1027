package ProblemSet_9b;

import java.util.regex.Pattern;

public class Service {
    private String code;
    private String name;
    private VATRate rate;

    private static final String PATTERN = "^[A-Z]{4}\\d{5}";

    public Service(String code, String name, VATRate rate) {
        Pattern pattern = Pattern.compile(PATTERN);
        if (code == null || name == null || rate == null) {
            throw new NullPointerException("Null parameter supplied");
        }
        if (!pattern.matcher(code).matches()) {
            throw new IllegalArgumentException("Badly formatted code");
        }

        this.name = name;
        this.rate = rate;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public VATRate getRate() {
        return this.rate;
    }
}
