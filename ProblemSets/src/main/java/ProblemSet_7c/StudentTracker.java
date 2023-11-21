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

    /**
     * Adds a Student object to the list of students.
     *
     * @param s Student
     * @param mList Module List
     */
    public void addStudent(Student s, List<Module> mList) {
        for (Module module : mList) {
            s.addModuleList(module);
        }
        this.studentList.add(s);
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
