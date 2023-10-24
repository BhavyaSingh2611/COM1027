package ProblemSet_4c;

public class Module {
	private String code = null;
	private double average = 0;

	public Module(String code, double average) {
		super();
		this.code = code;
		this.average = average;
	}

	public String getCode() {
		return this.code;
	}

	public double getAverage() {
		return this.average;
	}

	@Override
	public String toString() {
		return String.format("%s: %.1f",
				this.code, this.average);
	}
}
