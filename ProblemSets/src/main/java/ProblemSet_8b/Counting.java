package ProblemSet_8b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Counting {
    private BufferedReader reader;
    public Counting() {
        super();
    }

    public String readTextFile(String file) {
        StringBuilder toReturn = new StringBuilder();
        try {
            this.reader = new BufferedReader(new FileReader(file));
            String line = this.reader.readLine();
            int i = 0;

            while (line != null) {
                i++;
                toReturn.append(displayLine(line, i));
                line = this.reader.readLine();
            }

            this.reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toReturn.toString();
    }

    private String displayLine(String line, int index) {
        return line + " : " + index + "\n";
    }
}
