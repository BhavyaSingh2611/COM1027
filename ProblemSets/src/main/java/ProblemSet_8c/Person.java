package ProblemSet_8c;

public class Person {
    private String forename = null;
    private String surname = null;
    private int age = 0;

    /**
     * Constructs a person object.
     *
     * @param n forename
     * @param s surname
     * @param a age
     */
    public Person(String n, String s, int a) {
        super();
        this.forename = n;
        this.surname = s;
        this.age = a;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getForename() {
        return this.forename;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", this.forename,
                this.surname, this.age);
    }
}
