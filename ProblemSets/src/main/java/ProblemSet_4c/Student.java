package ProblemSet_4c;

import java.util.Arrays;

public class Student {
	private char initial;
	private String surname;
	private Module[] modules = {};

	public Student(char initial, String surname) {
		this.initial = initial;
		this.surname = surname;
		this.modules = Arrays.copyOf(modules, 8);
	}

	public String getStudentDetails() {
		return initial + ". " + surname + " ";
		 calculateYearAverage() + "%";
	}

	public int calculateYearAverage() {
		double total = 0;
		for (int i = 0; i < modules.length; i++) {
			total += modules[i].getAverage();
		}
		return (int) (total / 8);
	}

	public void setModules(int index, String code, double average) {
		modules[index] = new Module(code, average);
	}

	public Module getModules(int index) {
		return modules[index];
	}

	public String displayArray() {
		String toReturn = "";
		for (int i = 0; i < modules.length; i++) {
			toReturn += modules[i].getCode() + ": "
			+ modules[i].getAverage() + "\n";
		}
		toReturn += "Year Average: " + calculateYearAverage() + "%";
		return toReturn;
	}
}

