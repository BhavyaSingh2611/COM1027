package main.java.labs.Week_06;

import java.util.regex.Pattern;

public class Student {

    // -name:String

    private String name;
    public static final String PATTERN = "^[A-Z][a-z]*";

    public Student(String name) {
        super();
        if (name != null) {
            setName(name);
        }
    }

    public String getName() {
        return this.name;
    }

    /**
     * private method to help verifying student name One capital letter followed by
     * lower case letters
     * 
     * @param name
     */
    private void setName(String name) {
        Pattern pattern = Pattern.compile(PATTERN);
        if (pattern.matcher(name).matches()) {
            this.name = name;
        }
    }

    /**
     * @return only the name of the student
     */
    @Override
    public String toString() {
        return this.name;
    }

}
