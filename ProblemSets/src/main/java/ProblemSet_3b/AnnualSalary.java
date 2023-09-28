package ProblemSet_3b;

public class AnnualSalary {
    private double salary = 0.0;
    private final double PERSONAL_ALLOWANCE = 12570;

    public double calculateTax() {
        double tax = 0.0;

        if (salary > PERSONAL_ALLOWANCE && salary <= 50270) {
            tax += (salary - PERSONAL_ALLOWANCE) * 0.2;
        }

        if (salary > 50270 && salary <= 125140) {
            tax += (50270 - PERSONAL_ALLOWANCE) * 0.2;
            tax += (salary - 50270) * 0.4;
        }

        if (salary > 125140) {
            tax += (50270 - PERSONAL_ALLOWANCE) * 0.2;
            tax += (125140 - 50270) * 0.4;
            tax += (salary - 125140) * 0.45;
        }
        return tax;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
