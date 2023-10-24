package ProblemSet_3c;

public class Employee {
    private int id = 0;
    private String forename = null;
    private String surname = null;
    private AnnualSalary salary = null;
    private Position companyPosition = null;
    private static final double BONUS_THRESHOLD = 40000;

    public Employee(int id, String forename,
    		String surname, AnnualSalary salary,
    		Position companyPosition) {
        super();
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.salary = salary;
        this.companyPosition = companyPosition;
    }

    public int getId() {
        return this.id;
    }

    public String getForename() {
        return this.forename;
    }

    public String getSurname() {
        return this.surname;
    }

    public double getSalary() {
        return this.salary.getSalary();
    }

    public String getPositionName() {
        return this.companyPosition.getRoleName();
    }

    public void displayEmployeeName() {
        System.out.println(this.forename + " " + this.surname);
    }

    private boolean eligibleForBonus() {
        return (this.salary.getSalary() > BONUS_THRESHOLD);
    }
    @Override
    public String toString() {
        String bonus = this.eligibleForBonus() ? "" : " not";

        return String.format("%s, %s (%d): %s at £%.1f (£%.1f tax) "
                        + "and is%s eligible for bonus.",
                this.surname, this.forename, this.id, this.getPositionName(),
                this.salary.getSalary(), this.salary.calculateTax(), bonus);
    }
}
