package ProblemSet_9b;

public interface IGuest {
    /**
     * Creates a new Charge object with the parameters provided
     * and adds it to the list of charges.
     *
     * @param s Service
     * @param c Cost
     */
    void addCharge(Service s, double c);
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
     * @param r VATRate
     * @return total of products that meet the rate provided in parameter
     */
    double calculateVATChargeAtRate(VATRate r);
    /**
     * Calculates total post-VAT.
     *
     * @return total inclusive of VAT
     */
    double calculateTotalChargeIncVat();
    String toString();
}
