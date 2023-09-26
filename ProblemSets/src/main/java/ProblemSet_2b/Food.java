package ProblemSet_2b;

public class Food {
    private String name = "";
    private double amountOfSugar = 0.0;

    public Food(String name, double sugar) {
        this.name = name;
        this.amountOfSugar = sugar;
    }

    public double getAmountOfSugar() {
        return amountOfSugar;
    }

    public String getName() {
        return name;
    }
}
