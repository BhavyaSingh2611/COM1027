package ProblemSet_8b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Counting {
    public Counting() {
        super();
    }

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
    //TODO: ask about new line being in the function or in the loop?

    public String displayLine(String line, int counter) {
        return String.format("%s : %d\n", line, counter);
    }
}
