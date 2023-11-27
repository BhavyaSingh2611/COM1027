package ProblemSet_7b;

import java.util.regex.Pattern;

public class Module {
    private String name = null;
    private static final String PATTERN = "^COM\\d{4}$";
    public Module(String name) {
        super();
        this.name = name;
        Pattern pattern = Pattern.compile(PATTERN);
        if (!pattern.matcher(name).matches()) {
           this.name = "Error";
        }
    }

    public String getName() {
        return this.name;
    }
}
