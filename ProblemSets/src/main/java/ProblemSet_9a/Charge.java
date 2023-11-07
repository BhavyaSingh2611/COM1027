package ProblemSet_9a;

public class Charge {
    private Service service;
    private double amount = 0;

    public Charge(Service service, double amount)
            throws IllegalArgumentException {
        super();
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
        /* The first getRate returns the VATRate enum and the
        * second one is the enum getter to get the percentage
        * */
        return this.amount * this.service.getRate().getRate();
    }
}
