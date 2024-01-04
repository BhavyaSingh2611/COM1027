package Question_3;

public class Flat extends Property {
    private static final double MAINTENANCE_COSTS = 500;
    private int floor = 0;

    /**
     * Creates a new flat.
     *
     * @param houseNumber   House number
     * @param street        Street name
     * @param city          City name
     * @param postCode      Postcode
     * @param numberOfRooms Number of rooms
     * @param floor         Floor number
     * @throws IllegalArgumentException if the house number is less than
     *                                  or equals 0 or if the number of
     *                                  rooms is less than 1
     * @throws NullPointerException     if any of the parameters are null
     */
    public Flat(int houseNumber, String street, String city,
                String postCode, int numberOfRooms, int floor)
            throws IllegalArgumentException, NullPointerException {
        super(houseNumber, street, city, postCode, numberOfRooms);
        this.floor = floor;
    }

    /**
     * Gets the number of rooms available in the flat
     * if the property is available, else returns 0.
     *
     * @return the number of rooms available in the flat
     */
    @Override
    public int getAvailableRooms() {
        return this.isAvailable() ? super.getAvailableRooms() : 0;
    }

    /**
     * Gets the price of all the rooms in the flat.
     *
     * @return the sum of price of all the rooms in the flat
     */
    @Override
    public double getPrice() {
        return this.rooms.keySet()
                .stream()
                .limit(1)
                .mapToDouble(Room::getPrice)
                .sum() * this.getNumberOfRooms();
    }

    /**
     * Gets if the flat is available.
     *
     * @return if the flat is available
     */
    @Override
    public boolean isAvailable() {
        return this.rooms.isEmpty();
    }

    /**
     * Occupies a room in the flat with a tenant.
     *
     * @param r the room to occupy
     * @param t the tenant
     * @throws IllegalArgumentException if the room is already occupied
     *                                  or if the flat is full
     * @throws NullPointerException     if the room or tenant is null
     */
    @Override
    public void occupy(Room r, ITenant t)
            throws IllegalArgumentException, NullPointerException {
        if (r == null || t == null) {
            throw new NullPointerException("Room and tenant"
                    + " must not be null");
        }
        if (this.rooms.containsKey(r)) {
            throw new IllegalArgumentException("Room is already occupied");
        }
        if (!this.isAvailable()) {
            throw new IllegalArgumentException("Flat is full");
        }
        if (!t.getType().equals(TenantType.PROFESSIONAL)) {
            System.out.println("Only professionals can rent flats");
            return;
        }
        this.rooms.put(r, t);
    }

    /**
     * Displays all the rooms and total of the flat.
     *
     * @return string containing all the rooms and total of the flat
     */
    @Override
    public String displayOccupiedProperty() {
        StringBuilder output = new StringBuilder(this.toString())
                .append("\n");
        for (Room r : this.rooms.keySet()) {
            output.append(String.format("\t%s\n", r.toString()));
        }
        double price = (this.getPrice() * 12) + MAINTENANCE_COSTS;
        output.append(String.format("\tTotal: £%.2f (Council Tax: £%.1f)\n",
                price, this.getCouncilTax()));

        return output.toString();
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("flat on %d floor :%d available)",
                this.floor, this.getAvailableRooms());
    }
}
