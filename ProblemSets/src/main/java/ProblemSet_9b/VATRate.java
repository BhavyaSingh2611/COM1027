package ProblemSet_9b;

public enum VATRate {
    ZERO(0),
    LOW(5),
    STANDARD(20);

    private double rate;

    /**
     * Gets the percentage VAT.
     *
     * @return percentage of VAT as double
     */
    public double getRate() {
        return this.rate / 100;
    }

    VATRate(double rate) {
        this.rate = rate;
    }
}
