package ProblemSet_3b;

public class AnnualSalary {
    private double salary = 0.0;
    private final double PERSONAL_ALLOWANCE = 12570;

    public double calculateTax() {
        double tax = 0.0;
        if(salary > PERSONAL_ALLOWANCE){
            if (salary <= 50270){
                tax += (salary - PERSONAL_ALLOWANCE) * 0.2; /* 20% tax on the remaining salary*/
            } else {
                tax += (50270 - 12751) * 0.2; /* 20% tax upto 50270 */

                if (salary <= 125140){
                    tax += (salary - 50270) * 0.4; /* 40% tax on the remaining salary*/
                } else {
                    tax += (125140 - 50270) * 0.4; /* 40% tax upto 125140 */
                    tax += (salary - 125140) * 0.45; /* 45% tax above 125140 */
                }
            }
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
