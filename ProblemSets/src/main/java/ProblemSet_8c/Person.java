package ProblemSet_8c;

public class Person {
    private String forename = null;
    private String surname = null;
    private int age = 0;

    public Person(String forename, String surname, int age) {
        super();
        this.forename = forename;
        this.surname = surname;
        this.age = age;
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
