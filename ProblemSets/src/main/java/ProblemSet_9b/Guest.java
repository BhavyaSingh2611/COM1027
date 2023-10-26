package ProblemSet_9b;

import java.util.ArrayList;
import java.util.List;

public class Guest implements IGuest{

    private String forename;
    private String surname;
    private String address;
    private String telephone;
    private List<Charge> charges;
    public Guest(String forename, String surname, String address, String telephone) {
        super();
        this.forename = forename;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.charges = new ArrayList<Charge>();
    }

    public String getSurname() {
        return this.surname;
    }

    public String getForename() {
        return this.forename;
    }

    public List<Charge> getCharges() {
        return this.charges;
    }

    public String getAddress() {
        return this.address;
    }

    public String getTelephone() {
        return this.telephone;
    }

    @Override
    public void addCharge(Service service, double cost) {
        this.charges.add(new Charge(service, cost));
    }

    @Override
    public double calculateTotalChargeWithoutVAT() {
        double total = 0;
        for (Charge charge : this.charges) {
            total += charge.getCharge();
        }
        return total;
    }

    @Override
    public double calculateVATChargeAtRate(VATRate rate) {
        return this.calculateTotalChargeWithoutVAT() * rate.getRate();
    }

    @Override
    public double calculateTotalChargeIncVAT() {
        double total = 0;
        for (Charge charge : this.charges) {
            total += charge.getCharge() + charge.calculateVAT();
        }
        return total;
    }
}
