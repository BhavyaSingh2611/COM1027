package ProblemSet_2b;

public class Food {
    private String name;
    private double amountOfSugar;

    public Food(String name, double sugar) {
        super();
        this.name = name;
        this.amountOfSugar = sugar;
    }

    public double getAmountOfSugar() {
        return this.amountOfSugar;
    }

    public String getName() {
        return this.name;
    }
}
