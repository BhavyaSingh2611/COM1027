package ProblemSet_9a;

public class Charge {
    private Service service;
    private double amount = 0;

    /**
     * Amount should be greater than 0
     *
     * @param service
     * @param amount
     * @throws IllegalArgumentException if the amount is <= 0
     */
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

    /**
     * The rate at which the VAT is calculated is dependent on the service
     * VAT -> 0, 5, 20
     *
     * @return VAT calculated on the amount
     */
    public double calculateVAT() {
        /* The first getRate returns the VATRate enum and the
        * second one is the enum getter to get the percentage
        */
        return this.amount * this.service.getRate().getRate();
    }
}
