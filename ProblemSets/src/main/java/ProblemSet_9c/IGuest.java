package ProblemSet_9c;

public interface IGuest {
    void addCharge(Service service, double cost);
    double calculateTotalChargeWithoutVAT();
    double calculateVATChargeAtRate(VATRate rate);
    double calculateTotalChargeIncVat();
    String toString();
}
