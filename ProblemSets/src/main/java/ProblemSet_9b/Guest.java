package ProblemSet_9b;

import java.util.ArrayList;
import java.util.List;

public class Guest implements IGuest {

    private String forename = null;
    private String surname = null;
    private String address = null;
    private String telephone = null;
    private List<Charge> charges = null;

    /**
     * Creates a guest object.
     *
     * @param forename
     * @param surname
     * @param address
     * @param telephone
     */
    public Guest(String forename, String surname, String address,
                 String telephone) {
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

    /**
     * Creates a new Charge object with the parameters provided
     * and adds it to the list of charges.
     *
     * @param s Service
     * @param c Cost
     */
    @Override
    public void addCharge(Service s, double c) {
        this.charges.add(new Charge(s, c));
    }

    /**
     * Calculates total pre-VAT.
     *
     * @return total charge without VAT
     */
    @Override
    public double calculateTotalChargeWithoutVAT() {
        double total = 0;
        for (Charge charge : this.charges) {
            total += charge.getCharge();
        }
        return total;
    }

    /**
     * Calculates sum of all VAT percentages for all the charges that
     * the guest has incurred at the specified VAT rate.
     *
     * @param r VATRate
     * @return total of products that meet the rate provided in parameter
     */
    @Override
    public double calculateVATChargeAtRate(VATRate r) {
        double total = 0;
        for (Charge charge : this.charges) {
            if (charge.getService().getRate().equals(r)) {
                total += charge.calculateVAT();
            }
        }
        return total;
    }

    /**
     * Calculates total post-VAT.
     *
     * @return total inclusive of VAT
     */
    @Override
    public double calculateTotalChargeIncVat() {
        double total = 0;
        for (Charge charge : this.charges) {
            total += charge.getCharge() + charge.calculateVAT();
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, %s", this.forename, this.surname,
                this.address, this.telephone);
    }
}
