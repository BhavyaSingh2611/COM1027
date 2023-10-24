package ProblemSet_4b;

public class Classroom {
	private String room = null;
	private static final int CAPACITY = 20;
	private Student[] maxStudents = null;

	public Classroom(String room) {
		super();
		this.room = room;
		this.maxStudents = new Student[CAPACITY];
	}

	public void addStudents(int index, char initial, String surname) {
		this.maxStudents[index] = new Student(initial, surname);
	}

	public String getSummary() {
		String toReturn = "";
        for (Student student : this.maxStudents) {
            if (student != null) {
                toReturn += student.getStudentDetails()
                        + "\n";
            }
        }
		return toReturn.isEmpty() ? "No students added" : toReturn;
	}

	public int howManyStudents() {
		int numStudents = 0;
        for (Student student : this.maxStudents) {
            if (student != null) {
                numStudents++;
            }
        }
		return numStudents;
	}

	public String getRoom() {
		return this.room;
	}

	public int getCapacity() {
		return CAPACITY;
	}
}
