package ProblemSet_5c;

public class Pizza {
	private String[] toppings = null;

	public Pizza() {
		super();
		this.toppings = new String[0];
	}

	public void addToppings(String[] addToppings)
			throws IllegalArgumentException {
		if (addToppings.length > 10) {
			throw new IllegalArgumentException("Too Many Toppings");
		}
		this.toppings = addToppings;
	}

	public String printToppings() {
		return String.join(",", this.toppings);
	}

	public double calculateCost() {
		return switch (this.toppings.length) {
            case 1 -> 9.99;
            case 2, 3 -> 10.99;
            case 4, 5 -> 11.99;
            case 6 -> 12.99;
            case 7 -> 13.99;
            case 8 -> 14.99;
            case 9 -> 15.99;
            case 10 -> 14.99;
            default -> 0;
        };
	}
}
