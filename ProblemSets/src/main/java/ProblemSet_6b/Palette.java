package ProblemSet_6b;

import java.util.Arrays;

public class Palette {

    private P_COLOUR[] primaryColours = null;

    public Palette() {
        super();
        this.primaryColours = new P_COLOUR[3];
    }
    public Palette(P_COLOUR[] primaryColours) throws IllegalArgumentException {
        super();
        this.primaryColours = new P_COLOUR[3];
        if (primaryColours.length > 3) {
            throw new IllegalArgumentException("Too many colours");
        }
        for (P_COLOUR primaryColour : primaryColours) {
            if (primaryColour != null) {
                this.addColour(primaryColour);
            }
        }
    }

    public String getColours() {
        StringBuilder colourArr = new StringBuilder();
        for (P_COLOUR primaryColour : this.primaryColours) {
            if (primaryColour != null) {
                colourArr.append(primaryColour).append(", ");
            }
        }
        if (!colourArr.isEmpty()) {
            return colourArr.substring(0, colourArr.length() - 2);
        }
        return "No colours added";
    }

    public void addColour(P_COLOUR colour) throws IllegalArgumentException, NullPointerException {
        if (colour == null) {
            throw new NullPointerException("Null value supplied");
        }

        if (Arrays.asList(this.primaryColours).contains(colour)) {
            throw new IllegalArgumentException("Colour already added");
        }

        for (int i = 0; i < this.primaryColours.length; i++) {
           if (this.primaryColours[i] == null) {
            	this.primaryColours[i] = colour;
            	break;
            }
        }
    }
}
