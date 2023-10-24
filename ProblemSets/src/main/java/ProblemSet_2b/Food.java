package ProblemSet_2b;

public class Food {
    private String name = null;
    private double amountOfSugar = 0;

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
