package ProblemSet_5c;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<Pizza> pizzas = null;
	private Customer customer = null;

	public Order(Customer customer) {
		this.customer = customer;
		this.pizzas =  new ArrayList<Pizza>();
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
		return String.format("Customer: %s\nNumber of Pizzas:"
						+ " %d\nTotal Cost: %.2f",
				this.customer.toString(), this.pizzas.size(),
				this.calculateTotal());
	}

	public int howManyPizzasInOrder() {
		return this.pizzas.size();
	}

}
