package ProblemSet_8c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonTracker {
    private List<Person> peopleList = null;


    public PersonTracker() {
        super();
        this.peopleList = new ArrayList<Person>();
    }
    //TODO: Ask about the parameter name
    public void addPerson(String forename, String surname, int age)
            throws RuntimeException {
        this.peopleList.add(new Person(forename, surname, age));
    }
    public String readTextFile(String file) {
        StringBuilder toReturn = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            while (line != null) {
                this.breakLine(line);
                toReturn.append(String.format("%s\n", line));
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return toReturn.toString();
    }

    private void breakLine(String line) {
        String[] parts = line.split(" ");
        this.addPerson(parts[0], parts[1], Integer.parseInt(parts[2]));
    }

    public String getPeopleList() {
        return this.peopleList.toString();
    }

    public String displayList() {
        StringBuilder toReturn = new StringBuilder();
        for (Person person : this.peopleList) {
            toReturn.append(person.toString()).append("\n");
        }
        return toReturn.toString();
    }
}
