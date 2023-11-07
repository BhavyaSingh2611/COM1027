package ProblemSet_9c;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<IGuest> guests;

    /**
     *
     * @param name name of the hotel
     */
    public Hotel(String name) {
        this.name = name;
        this.guests = new ArrayList<IGuest>();
    }

    /**
     * Adds guest to the hotel guest list.
     *
     * @param guest
     */

    public void addGuest(IGuest guest) {
        this.guests.add(guest);
    }

    public List<IGuest> getGuests() {
        return this.guests;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Returns the guest list with the hotel name on top.
     *
     * @return list of all guests in the hotel
     */

    public String printGuestList() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append(this.name).append(" Hotel")
                .append("\n").append("Guest List\n");
        for (IGuest guest : this.guests) {
            toReturn.append(guest.toString()).append("\n");
        }

        return toReturn.toString();
    }
}
