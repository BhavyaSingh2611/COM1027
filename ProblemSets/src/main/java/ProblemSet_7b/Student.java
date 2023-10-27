package ProblemSet_7b;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Student {
    private String name = null;
    private String urn = null;
    private List<Module> moduleList;
    private static final String NAME_PATTERN = "^[A-Z][a-z]* [A-Z][a-z]*$";
    private static final String URN_PATTERN = "\\d{5}";
    public Student(String name, String urn) throws IllegalArgumentException {
        super();
        this.moduleList = new ArrayList<Module>();
        this.name = name;
        this.urn = urn;

        Pattern namePattern = Pattern.compile(NAME_PATTERN);
        Pattern urnPattern = Pattern.compile(URN_PATTERN);

        if (!namePattern.matcher(name).matches()) {
            throw new IllegalArgumentException("Badly formatted name");
        }
        if (!urnPattern.matcher(urn).matches()) {
            this.urn = "00000";
        }
    }

    public String getName() {
        return this.name;
    }

    public int getUrn() {
        return Integer.parseInt(this.urn);
    }

    public void addModuleList(Module module) {
        if ((module != null) && (!this.moduleList.contains(module))) {
            this.moduleList.add(module);
        }
    }

    public String printModules() {
        StringBuilder toReturn = new StringBuilder();
        for (Module module : this.moduleList) {
            toReturn.append(module.getName()).append(", ");
        }
        return toReturn.substring(0, toReturn.length() - 2);
    }
}
