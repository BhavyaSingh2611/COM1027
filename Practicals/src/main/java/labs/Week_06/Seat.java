package main.java.labs.Week_06;

public class Seat {

    /**
     * -student: Student +getName():String +toString():String
     * Notes: a parameterized constructor is required if student object is null the
     * getName() method returns null otherwise the student's name the toString()
     * method returns the functionality specified in the getName()
     */

    private Student student = null;

    public Seat(Student student) {
        super();
        this.student = student;
    }
    public String getName() {
        return this.student.getName();
    }

    @Override
    public String toString() {
        if (student == null) {
            return null;
        }
        return this.student.getName();
    }
}
