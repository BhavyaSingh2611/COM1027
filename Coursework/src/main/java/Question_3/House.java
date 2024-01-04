package Question_3;

public class House extends Property {
    /**
     * Creates a new house.
     *
     * @param houseNumber   the house number
     * @param street        the street
     * @param city          the city
     * @param postCode      the post code
     * @param numberOfRooms the number of rooms in the house
     * @throws IllegalArgumentException if the house number is less than
     *                                  or equals 0 or if the number
     *                                  of rooms is less than 1
     * @throws NullPointerException     if the street, city or
     *                                  post code is null
     */
    public House(int houseNumber, String street, String city,
                 String postCode, int numberOfRooms)
            throws IllegalArgumentException, NullPointerException {
        super(houseNumber, street, city, postCode, numberOfRooms);
    }

    /**
     * Gets the price of all the rooms in the house.
     *
     * @return the sum of price of all the rooms in the house
     */
    @Override
    public double getPrice() {
        return this.rooms.keySet().stream().mapToDouble(Room::getPrice).sum();
    }

    /**
     * Checks if the house has at least one room available.
     *
     * @return true if there is at least one room available in the house
     */
    @Override
    public boolean isAvailable() {
        return this.getAvailableRooms() > 0;
    }

    /**
     * Occupies a room in the house with a tenant.
     *
     * @param r the room to occupy
     * @param t the tenant
     * @throws IllegalArgumentException if the room is already occupied
     *                                  or if the house is full
     * @throws NullPointerException     if the room or tenant is null
     */
    @Override
    public void occupy(Room r, ITenant t) {
        if (r == null || t == null) {
            throw new IllegalArgumentException("Room and tenant"
                    + " must not be null");
        }
        if (this.rooms.containsKey(r)) {
            throw new IllegalArgumentException("Room is already occupied");
        }
        if (!this.isAvailable()) {
            throw new IllegalArgumentException("House is full");
        }
        this.rooms.put(r, t);
    }

    /**
     * Displays all the rooms and total of the house.
     *
     * @return string containing all the rooms and total of the house
     */
    @Override
    public String displayOccupiedProperty() {
        StringBuilder output = new StringBuilder(this.toString()).append("\n");
        for (Room r : this.rooms.keySet()) {
            output.append(String.format("\t%s\n", r.toString()));
        }
        double price = (this.getPrice() * 12);
        output.append(String.format("\tTotal: £%.2f (Council Tax: £%.1f)\n",
                price, this.getCouncilTax()));

        return output.toString();
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("house :%d available)",
                this.getAvailableRooms());
    }
}
