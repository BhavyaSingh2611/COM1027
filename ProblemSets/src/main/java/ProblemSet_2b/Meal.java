package ProblemSet_2b;

public class Meal {
    private Food mainCourse = null;
    private Food dessert = null;
    public Meal(Food mainCourse, Food dessert) {
        super();
        this.mainCourse = mainCourse;
        this.dessert = dessert;
    }

    public double calculateTotalSugarLevel() {
        return this.mainCourse.getAmountOfSugar()
                + this.dessert.getAmountOfSugar();
    }
    @Override
    public String toString() {
        return String.format("Meal [mainCourse = %s, dessert = %s]",
                this.mainCourse.getName(), this.dessert.getName());
    }
}
