package ProblemSet_4c;

public class Student {
	private char initial;
	private String surname;
	private Module[] modules;

	public Student(char initial, String surname) {
		super();
		this.initial = initial;
		this.surname = surname;
		this.modules = new Module[8];
	}

	public String getStudentDetails() {
		return this.initial + ". "
				+ this.surname + " "
				+ this.calculateYearAverage()
				+ "%";
	}

	public int calculateYearAverage() {
		double total = 0;
        for (Module module : this.modules) {
            total += module.getAverage();
        }
		return (int) (total / this.modules.length);
	}

	public void setModules(int index, String code, double average) {
		this.modules[index] = new Module(code, average);
	}

	public Module getModules(int index) {
		return this.modules[index];
	}

	public String displayArray() {
		String toReturn = "";
        for (Module module : this.modules) {
            toReturn += module + "\n";
        }
		toReturn += "Year Average: "
				+ this.calculateYearAverage() + "%";
		return toReturn;
	}
}

