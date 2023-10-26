package ProblemSet_8c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonTracker {
    private List<Person> peopleList = new ArrayList<Person>();
    private BufferedReader reader;


    public PersonTracker() {
        super();
    }

    public void addPerson(String forename, String surname, int age) {
        this.peopleList.add(new Person(forename, surname, age));
    }
    public void readTextFile(String file) {
        try {
            this.reader = new BufferedReader(new FileReader(file));
            String line = this.reader.readLine();

            while (line != null) {
                breakLine(line);
                line = this.reader.readLine();
            }

            this.reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
