package ProblemSet_5c;

public class Customer {
	private String name;
	private String surname;

	public Customer(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public char getName() {
		return this.name.charAt(0);
	}

	public String getSurname() {
		return this.surname;
	}

	@Override
	public String toString() {
		return this.getName() + ". " + this.surname;
	}
}
