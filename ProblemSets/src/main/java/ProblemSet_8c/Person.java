package ProblemSet_8c;

public class Person {
    private String forename;
    private String surname;
    private int age;

    public Person(String forename, String surname, int age) {
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
        return String.format("%s %s (%d)", this.forename, this.surname, this.age);
    }
}
