package Question_3;

public enum Severity {

    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private int severity = 0;

    public int getWeight() {
        return this.severity;
    }

    Severity(int rate) {
        this.severity = rate;
    }
}
