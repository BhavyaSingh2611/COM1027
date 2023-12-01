package ProblemSet_8b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Counting {
    /**
     * Creates a counting object.
     */
    public Counting() {
        super();
    }

    /**
     * Reads the text file name supplied.
     *
     * @param file name of the file to be read
     * @return contents of the file formatted with the line number
     * @throws RuntimeException if the file read operation fails
     */
    public String readTextFile(String file) throws RuntimeException {
        StringBuilder toReturn = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int i = 0;

            while (line != null) {
                i++;
                toReturn.append(displayLine(line, i));
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        return toReturn.toString();
    }

    /**
     * Formats the line with the counter parameter supplied.
     *
     * @param line    line to display
     * @param counter line number to display beside it
     * @return returns formatted line with line number
     */
    public String displayLine(String line, int counter) {
        return String.format("%s : %d\n", line, counter);
    }
}
