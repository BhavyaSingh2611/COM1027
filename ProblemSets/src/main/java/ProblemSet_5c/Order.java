package ProblemSet_5c;

import java.util.ArrayList;

public class Order {
	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	private Customer customer;

	public Order(Customer customer) {
		this.customer = customer;
	}

	public double calculateTotal() {
		double cost = 0;
		for (int i = 0; i < pizzas.size(); i++) {
			cost += pizzas.get(i).calculateCost();
		}
		return cost;
	}

	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}

	public String printReceipt() {
		return "Customer: " + customer.toString() + "\n"
				+ "Number of Pizzas: "
				+ pizzas.size() + "\n"
				+ "Total Cost: " + calculateTotal();
	}

}
