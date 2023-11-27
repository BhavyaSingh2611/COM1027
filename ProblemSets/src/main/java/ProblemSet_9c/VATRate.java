package ProblemSet_9c;

public enum VATRate {
    ZERO(0),
    LOW(5),
    STANDARD(20);

    private double rate = 0;

    /**
     * Gets the percentage VAT.
     *
     * @return percentage of VAT as double
     */
    public double getPercentage() {
        return this.rate / 100;
    }

    VATRate(double rate) {
        this.rate = rate;
    }
}
