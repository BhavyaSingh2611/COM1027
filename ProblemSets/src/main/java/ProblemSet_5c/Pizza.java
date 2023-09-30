package ProblemSet_5c;

public class Pizza {
	private String[] toppings = {};

	public void addToppings(String[] addToppings) {
		this.toppings = addToppings;
	}

	public String printToppings() {
		return String.join(",", toppings);
	}

	public double calculateCost() {
		double cost = 0;
		switch (toppings.length) {
		  case 1:
		    cost = 9.99;
		    break;
		  case 2:
		    cost = 10.99;
		    break;
		  case 3:
		    cost = 10.99;
		    break;
		  case 4:
		    cost = 11.99;
		    break;
		  case 5:
		    cost = 11.99;
		    break;
		  case 6:
		    cost = 12.99;
		    break;
		  case 7:
		    cost = 13.99;
		    break;
		  case 8:
			cost = 14.99;
			break;
		  case 9:
			cost = 15.99;
			break;
		  case 10:
			cost = 14.99;
			break;
		  default:
			cost = 0;
			break;
		}
		return cost;
	}
}
