package ProblemSet_4b;

public class Student {
	private char initial = 0;
	private String surname = null;

	public Student(char initial, String surname) {
		super();
		this.initial = initial;
		this.surname = surname;
	}

	public String getStudentDetails() {
		return initial + ". " + surname;
	}
}
