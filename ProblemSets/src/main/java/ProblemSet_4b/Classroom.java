package ProblemSet_4b;

import java.util.Arrays;

public class Classroom {
	private String room;
	private final int CAPACITY = 20;
	private Student[] maxStudents = {};

	public Classroom(String room) {
		this.room = room;
		this.maxStudents = Arrays.copyOf(maxStudents, CAPACITY);
	}

	public void addStudents(int index, char initial, String surname) {
		maxStudents[index] = new Student(initial, surname);
	}

	public String getSummary() {
		String toReturn = "";
		for (int i = 0; i < maxStudents.length; i++) {
			if (maxStudents[i] != null) {
				toReturn += maxStudents[i].getStudentDetails()
				+ "\n";
			}
		}
		if (toReturn == "") {
			return "No students added";
		}
		return toReturn;
	}

	public int howManyStudents() {
		int numStudents = 0;
		for (int i = 0; i < maxStudents.length; i++) {
			if (maxStudents[i] != null) {
				numStudents++;
			}
		}
		return numStudents;
	}

	public String getRoom() {
		return room;
	}

	public int getCapacity() {
		return CAPACITY;
	}
}
