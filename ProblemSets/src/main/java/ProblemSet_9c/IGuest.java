package ProblemSet_9c;

public interface IGuest {
    /**
     * Creates a new Charge object with the parameters provided
     * and adds it to the list of charges.
     * @param service
     * @param cost
     */
    void addCharge(Service service, double cost);
    /**
     * Calculates total pre-VAT.
     *
     * @return total charge without VAT
     */
    double calculateTotalChargeWithoutVAT();
    /**
     * Calculates sum of all VAT percentages for all the charges that
     * the guest has incurred at the specified VAT rate.
     *
     * @param rate
     * @return total of products that meet the rate provided in parameter
     */
    double calculateVATChargeAtRate(VATRate rate);
    /**
     * Calculates total post-VAT.
     *
     * @return total inclusive of VAT
     */
    double calculateTotalChargeIncVat();
    String toString();
}
