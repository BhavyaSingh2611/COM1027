package ProblemSet_6c;

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

    public void addColour(P_COLOUR colour)
            throws IllegalArgumentException, NullPointerException {
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

    public String display() {
        return this.getColours() + " = " + this.mixColours();
    }

    public String mixColours() {
        String[] colourMap = {"0", "0", "0"};
        for (P_COLOUR primaryColour : this.primaryColours) {
            if (primaryColour != null) {
                if (primaryColour.equals(P_COLOUR.RED)) {
                    colourMap[0] = "1";
                } else if (primaryColour.equals(P_COLOUR.BLUE)) {
                    colourMap[1] = "1";
                } else if (primaryColour.equals(P_COLOUR.YELLOW)) {
                    colourMap[2] = "1";
                }
            }
        }

        return switch (String.join("", colourMap)) {
            case "100" -> "RED";
            case "010" -> "BLUE";
            case "001" -> "YELLOW";
            case "101" -> "ORANGE";
            case "110" -> "PURPLE";
            case "011" -> "GREEN";
            case "111" -> "BLACK";
            default -> "";
        };
    }
}
