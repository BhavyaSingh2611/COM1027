package ProblemSet_9b;

public class Charge {
    private Service service;
    private double amount;

    public Charge(Service service, double amount)
            throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Negative/Zero Amount");
        }
        this.service = service;
        this.amount = amount;
    }

    public Service getService() {
        return this.service;
    }

    public double getCharge() {
        return this.amount;
    }

    public double calculateVAT() {
        return this.amount * this.service.getRate().getRate();
    }
}
