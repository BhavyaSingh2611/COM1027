package ProblemSet_2c;

public class Assessment {
    private String name = "";
    private double mark = 0.0;
    public Assessment(String name, double mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }
}
