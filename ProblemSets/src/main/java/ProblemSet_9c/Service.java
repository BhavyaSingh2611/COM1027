package ProblemSet_9c;

import java.util.regex.Pattern;

public class Service {
    private String code = null;
    private String name = null;
    private VATRate rate = null;

    private static final String PATTERN = "^[A-Z]{4}\\d{5}$";

    /**
     * Creates a service object.
     *
     * @param code
     * @param name
     * @param rate
     * @throws NullPointerException if any parameters is null
     * @throws IllegalArgumentException if code doesn't match "^[A-Z]{4}\\d{5}$"
     */
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
