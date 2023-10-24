package ProblemSet_2c;

public class Assessment {
    private String name = null;
    private double mark = 0;
    public Assessment(String name, double mark) {
        super();
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return this.name;
    }

    public double getMark() {
        return this.mark;
    }
}
