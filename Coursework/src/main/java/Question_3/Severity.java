package Question_3;

public enum Severity {

    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private int severity = 0;

    /**
     * Returns the severity of the complaint.
     *
     * @return the severity of the complaint
     */
    public int getWeight() {
        return this.severity;
    }

    /**
     * Constructor for Severity.
     *
     * @param rate the severity of the complaint
     */
    Severity(int rate) {
        this.severity = rate;
    }
}
