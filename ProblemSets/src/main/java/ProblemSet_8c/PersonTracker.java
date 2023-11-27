package ProblemSet_8c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonTracker {
    private List<Person> peopleList = null;

    /**
     * Creates a PersonTracker object.
     */
    public PersonTracker() {
        super();
        this.peopleList = new ArrayList<Person>();
    }

    /**
     * Adds a Person object to person list.
     *
     * @param n forename
     * @param s surname
     * @param a age
     */
    public void addPerson(String n, String s, int a) {
        this.peopleList.add(new Person(n, s, a));
    }

    /**
     * Reads the text file name supplied.
     *
     * @param file name of the file to be read
     * @return contents of the file
     * @throws RuntimeException if the file read operation fails
     */
    public String readTextFile(String file) throws RuntimeException {
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

    /**
     * Parses the line supplied and constructs a Person object
     * to add to the list.
     *
     * @param line space separated line containing name surname and age
     */
    private void breakLine(String line) {
        String[] parts = line.split(" ");
        this.addPerson(parts[0], parts[1], Integer.parseInt(parts[2]));
    }

    /**
     * Gets the list of all the people present in the tracker.
     *
     * @return all elements in people list
     */
    public String getPeopleList() {
        return this.peopleList.toString();
    }

    /**
     * Returns list of all the people present in the tracker.
     *
     * @return all people on new line
     */
    public String displayList() {
        StringBuilder toReturn = new StringBuilder();
        for (Person person : this.peopleList) {
            toReturn.append(person.toString()).append("\n");
        }
        return toReturn.toString();
    }
}
