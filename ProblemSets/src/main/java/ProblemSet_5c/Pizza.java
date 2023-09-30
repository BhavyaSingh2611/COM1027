package ProblemSet_5c;

import java.util.ArrayList;

public class Pizza {
	private ArrayList<String> toppings = new ArrayList<String>();
	
	
	public void addToppings(String[] addToppings) {
		for (int i = 0; i < addToppings.length; i++) {
			this.toppings.add(addToppings[i]);
		}
	}
	
	public String printToppings() {
		return String.join(",", toppings);
	}

	public double calculateCost() {
		double cost = 0;
		switch (toppings.size()) {
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
		}
		return cost;
	}
}
