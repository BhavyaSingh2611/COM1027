package ProblemSet_6b;

public class Palette {

    private P_COLOUR[] primaryColours = null;

    public Palette() {
        super();
        this.primaryColours = new P_COLOUR[3];
    }

    public Palette(P_COLOUR[] primaryColours) {
        super();
        this.primaryColours = primaryColours;
    }

    public String getColours() {
        String colourArr = "";
        for (int i = 0; i < this.primaryColours.length; i++) {
            if (this.primaryColours[i] != null) {
                colourArr += this.primaryColours[i].toString() + ",";
            }
        }
        if (!colourArr.isEmpty()) {
            colourArr = colourArr.substring(colourArr.length() - 1);
            return colourArr;
        }
        return "No colours added";
    }

    public void addColour(P_COLOUR pColour) {
        for (int i = 0; i < this.primaryColours.length; i++) {
            if (pColour == this.primaryColours[i]) { break; }
            if (this.primaryColours[i] == null) { this.primaryColours[i] = pColour; }
        }
    }
}
