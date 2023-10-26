package ProblemSet_6b;

public class Palette {

    private P_COLOUR[] primaryColours = null;

    public Palette() {
        super();
        this.primaryColours = new P_COLOUR[3];
    }
    public Palette(P_COLOUR[] primaryColours) {
        super();
        this.primaryColours = new P_COLOUR[3];
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
            colourArr = new StringBuilder(colourArr.substring(0,
                    colourArr.length() - 2));
            return colourArr.toString();
        }
        return "No colours added";
    }

    public void addColour(P_COLOUR pColour) {
        for (int i = 0; i < this.primaryColours.length; i++) {
            if ((pColour != this.primaryColours[i])
                    && (this.primaryColours[i] == null)) {
            	this.primaryColours[i] = pColour;
            	break;
            }
        }
    }
}
