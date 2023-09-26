package ProblemSet_3c;

public class Employee {
    private int id = 0;
    private String forename = "";
    private String surname = "";
    private AnnualSalary salary = null;
    private Position companyPosition = null;

    public Employee(int id, String forename, String surname, AnnualSalary salary, Position companyPosition) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.salary = salary;
        this.companyPosition = companyPosition;
    }

    public int getId() {
        return id;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public int getSalary() {
        return (int) salary.getSalary();
    }

    public String getPositionName() {
        return companyPosition.getRoleName();
    }

    public void displayEmployeeName(){
        System.out.println(forename + " " + surname);
    }

    private boolean eligibleForBonus(){
        return  false;
    }

    public String toString(){
        String bonus = eligibleForBonus() ? "" : "not ";
        return forename + ", " + surname + "(" + id + ") " + getPositionName() + " at �" + salary.getSalary() + " (�" + salary.calculateTax() + " tax) and is " + bonus + "eligible for bonus.";
    }
}
