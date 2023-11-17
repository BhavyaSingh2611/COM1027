package ProblemSet_7c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTracker {
    private List<Student> studentList = null;
    private Map<Integer, Student> moduleList = null;

    public StudentTracker() {
        super();
        this.studentList = new ArrayList<Student>();
        this.moduleList = new HashMap<Integer, Student>();
    }

    //TODO: Ask about the parameter names
    public void addStudent(Student student, List<Module> modules) {
        for (Module module : modules) {
            student.addModuleList(module);
        }
        this.studentList.add(student);
    }

    private void initialiseMap() {
        for (Student student : this.studentList) {
            this.moduleList.put(student.getUrn(), student);
        }
    }

    public String printStudents() {
        StringBuilder toReturn = new StringBuilder();
        for (Student student : this.studentList) {
            toReturn.append(student).append("\n");
        }
        return toReturn.toString();
    }

    public String printModules(int urn) {
        this.initialiseMap();
        StringBuilder moduleReturn = new StringBuilder();
        if (this.moduleList.containsKey(urn)) {
            moduleReturn.append(String.format("URN %d is enrolled in:\n", urn));
            moduleReturn.append(this.moduleList.get(urn).printModules());
        }
        return moduleReturn.toString();
    }
}
