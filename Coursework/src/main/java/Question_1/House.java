package Question_1;

import java.util.HashMap;
import java.util.Map;

public class House {
    private int houseNumber = 0;
    private String street = null;
    private String city = null;
    private String postCode = null;
    private int numberOfRooms = 0;
    private Map<Room, ITenant> rooms = null;
    private static final String CITY_REGEX = "^[A-Z][a-z]*";
    private static final String POSTCODE_REGEX = "^GU\\d{2}[A-Z]{2}$";

    /**
     * Creates a new house.
     *
     * @param houseNumber   the house number
     * @param street        the street
     * @param city          the city
     * @param postCode      the post code
     * @param numberOfRooms the number of rooms in the house
     * @throws IllegalArgumentException if the house number is less than or
     *                                  equals 0 or if the number of rooms is
     *                                  less than 1
     * @throws NullPointerException     if the street, city or post code is null
     */
    public House(int houseNumber, String street, String city, String postCode,
                 int numberOfRooms)
            throws IllegalArgumentException, NullPointerException {
        super();
        if (this.nullCheck(street, city, postCode)) {
            throw new NullPointerException("Street, city and post"
                    + " code must not be null");
        }
        if (houseNumber <= 0) {
            throw new IllegalArgumentException("House number"
                    + " should be positive non-zero number");
        }
        if (!this.validateCity(city)) {
            throw new IllegalArgumentException("City must start"
                    + " with a capital letter");
        }
        if (!this.validatePostCode(postCode
                .replace(" ", ""))) {
            throw new IllegalArgumentException("Post code must"
                    + " be in the format GU00XX or GU0 0XX");
        }
        if (numberOfRooms < 1) {
            throw new IllegalArgumentException("Number of rooms"
                    + " must be at least 1");
        }

        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.numberOfRooms = numberOfRooms;
        this.rooms = new HashMap<Room, ITenant>();
    }

    /**
     * Gets the number of rooms available in the house.
     *
     * @return the number of rooms available in the house
     */
    public int getAvailableRooms() {
        return this.numberOfRooms - this.rooms.size();
    }


    /**
     * Gets the price of all the rooms in the house.
     *
     * @return the sum of price of all the rooms in the house
     */
    public double getPrice() {
        return this.rooms.keySet().stream().mapToDouble(Room::getPrice).sum();
    }

    /**
     * Checks if the house has at least one room available.
     *
     * @return true if there is at least one room available in the house
     */
    public boolean isAvailable() {
        return this.getAvailableRooms() > 0;
    }

    /**
     * Occupies a room in the house with a tenant.
     *
     * @param r the room to occupy
     * @param t the tenant to occupy the room with
     * @throws IllegalArgumentException if the room is already
     *                                  occupied or if the house is full
     * @throws NullPointerException     if the room or tenant is null
     */
    public void occupy(Room r, ITenant t)
            throws IllegalArgumentException, NullPointerException {
        if (this.nullCheck(r, t)) {
            throw new NullPointerException("Room and tenant must not be null");
        }
        if (this.rooms.containsKey(r)) {
            throw new IllegalArgumentException("Room is already occupied");
        }
        if (!this.isAvailable()) {
            throw new IllegalArgumentException("House is full");
        }
        this.rooms.put(r, t);
    }

    @Override
    public String toString() {
        return String.format("%d %s, %s %s (%d bedroom house :%d available)",
                this.houseNumber, this.street, this.city,
                this.postCode, this.numberOfRooms, this.getAvailableRooms());
    }

    private boolean validateCity(String input) {
        return input != null && input.matches(CITY_REGEX);
    }

    private boolean validatePostCode(String input) {
        return input != null && input.matches(POSTCODE_REGEX);
    }

    private boolean nullCheck(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                return true;
            }
        }
        return false;
    }
}
