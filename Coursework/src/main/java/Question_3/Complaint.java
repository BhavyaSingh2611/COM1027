package Question_3;

public class Complaint {
    private String title = null;
    private Severity severity = null;

    /**
     * Creates a new complaint.
     *
     * @param title    the title of the complaint
     * @param severity the severity of the complaint
     */
    public Complaint(String title, Severity severity) {
        super();
        this.title = title;
        this.severity = severity;
    }

    public Severity getSeverity() {
        return this.severity;
    }

    public String getTitle() {
        return this.title;
    }
}
