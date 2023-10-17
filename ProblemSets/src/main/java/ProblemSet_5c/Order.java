package ProblemSet_5c;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<Pizza> pizzas = new ArrayList<Pizza>();
	private Customer customer;

	public Order(Customer customer) {
		this.customer = customer;
	}

	public double calculateTotal() {
		double cost = 0;
        for (Pizza pizza : this.pizzas) {
            cost += pizza.calculateCost();
        }
		return cost;
	}

	public void addPizza(Pizza pizza) {
		this.pizzas.add(pizza);
	}

	public String printReceipt() {
		return String.format("Customer: %s\nNumber of Pizzas: %d\nTotal Cost: %.2f",
				this.customer.toString(), this.pizzas.size(), this.calculateTotal());
	}

}
