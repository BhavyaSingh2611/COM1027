package ProblemSet_2b;

public class Meal {
    private Food mainCourse = null;
    private Food dessert = null;
    public Meal(Food mainCourse, Food dessert) {
        this.mainCourse = mainCourse;
        this.dessert = dessert;
    }

    public double calculateTotalSugarLevel() {
        return mainCourse.getAmountOfSugar() + dessert.getAmountOfSugar();
    }

    public String toString() {
        return "Meal [mainCourse = " + mainCourse.getName()
                + ", dessert = " + dessert.getName() + "]";
    }
}
