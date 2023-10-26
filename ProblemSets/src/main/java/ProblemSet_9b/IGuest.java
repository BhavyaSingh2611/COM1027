package ProblemSet_9b;

public interface IGuest {
    void addCharge(Service service, double cost);
    double calculateTotalChargeWithoutVAT();
    double calculateVATChargeAtRate(VATRate rate);
    double calculateTotalChargeIncVAT();
    String toString();
}
