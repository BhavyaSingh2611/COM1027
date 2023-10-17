package ProblemSet_3b;

public class AnnualSalary {
    private double salary = 0.0;
    private static final double PERSONAL_ALLOWANCE = 12570;

    public AnnualSalary() {
        super();
    }

    public double calculateTax() {
        double tax = 0.0;
        double salary = this.salary;

        /*
         * Constants for calculating the tax
         * */
        final double TIER1 = 50270;
        final double TIER1_PERCENTAGE = 0.2;
        final double TIER2 = 125140;
        final double TIER2_PERCENTAGE = 0.4;
        final double TIER3_PERCENTAGE = 0.45;

        if (salary > PERSONAL_ALLOWANCE && salary <= TIER1) {
            tax += (salary - PERSONAL_ALLOWANCE) * TIER1_PERCENTAGE;
        }

        if (salary > TIER1 && salary <= TIER2) {
            tax += (TIER1 - PERSONAL_ALLOWANCE) * TIER1_PERCENTAGE;
            tax += (salary - TIER1) * TIER2_PERCENTAGE;
        }

        if (salary > TIER2) {
            tax += (TIER1 - PERSONAL_ALLOWANCE) * TIER1_PERCENTAGE;
            tax += (TIER2 - TIER1) * TIER2_PERCENTAGE;
            tax += (salary - TIER2) * TIER3_PERCENTAGE;
        }
        return tax;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
