package ProblemSet_5b;

import java.util.regex.Pattern;

public class GasBill {
	private String accountNumber = null;
	private double amount = 0;
	private Customer customer = null;

	public GasBill(String accountNumber, double amount, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.customer = customer;

		if (!this.checkAccountAccuracy(accountNumber)) {
			System.out.println("Invalid Account Number Supplied");
		}
	}

	public boolean checkAccountAccuracy(String accountNumber) {
		Pattern pattern = Pattern.compile("^G\\d{4}-\\d{4}-\\d{4}");
		if (!pattern.matcher(accountNumber).matches()) {
			this.accountNumber = "Invalid Account";
		}

		return pattern.matcher(accountNumber).matches();
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public String getCustomer() {
		return this.customer.toString();
	}

	public String displayAccountDetails() {
		return String.format("Gas Bill\n Account Number:"
						+ "%s\n Customer:%s\n %s",
				this.accountNumber, this.getCustomer(),
				this.displayAmountDue());
	}

	public String displayAmountDue() {
		// https://tinyurl.com/2decimal
		return String.format("Amount due:£%.2f", this.amount);
	}
}
