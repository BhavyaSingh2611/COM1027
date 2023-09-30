package ProblemSet_5b;

public class GasBill {
	private String accountNumber = "";
	private double amount = 0;
	private Customer customer = null;
	
	public GasBill(String accountNumber, double amount, Customer customer) {
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.customer = customer;
	}
	
	public boolean checkAccountAccuracy(String accountNumber) {
		if (accountNumber.startsWith("G")) {
			String[] partString = accountNumber.split("G")[1].split("-");
			if (partString.length == 3) {
				for (int i = 0; i < partString.length; i++) {
					if (!partString[i].matches("[0-9]+")) {
						this.accountNumber = "Invalid Account";
						return false;
					}
				}
				boolean arePartsValid = (partString[0].length() == 4)
						&& (partString[1].length() == 4)
						&& (partString[2].length() == 4);
				if(!arePartsValid) {
					this.accountNumber = "Invalid Account";
				}
				return arePartsValid;
			}
		}
		this.accountNumber = "Invalid Account";
		return false;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getCustomer() {
		return customer.toString();
	}
	
	public double getAmount() {
		return amount;
	}

	public String displayAccountDetails() {
		return "Gas Bill\n Account Number:"
				+ accountNumber +"\n"
				+ " Customer:" + getCustomer()
				+ "\n " + displayAmountDue();
	}
	
	public String displayAmountDue() {
		// https://stackoverflow.com/questions/8819842/best-way-to-format-a-double-value-to-2-decimal-places
		return "Amount due:�" + String.format("%.2f", amount);
	}
	
}
