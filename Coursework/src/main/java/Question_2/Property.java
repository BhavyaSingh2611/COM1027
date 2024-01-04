package Question_2;

import java.util.HashMap;
import java.util.Map;

public abstract class Property {
    private int houseNumber = 0;
    private String street = null;
    private String city = null;
    private String postCode = null;
    private int numberOfRooms = 0;
    protected Map<Room, ITenant> rooms = null;
    protected double councilTax = 0;
    private static final String CITY_REGEX = "^[A-Z][a-z]*";
    private static final String POSTCODE_REGEX = "^GU\\d{2}[A-Z]{2}$";

    /**
     * Creates a new property.
     *
     * @param houseNumber   the house number
     * @param street        the street
     * @param city          the city
     * @param postCode      the post code
     * @param numberOfRooms the number of rooms in the property
     * @throws IllegalArgumentException if the house number is less
     *                                  than or equals 0 or if the
     *                                  number of rooms is less than 1
     * @throws NullPointerException     if the street, city or
     *                                  post code is null
     */
    public Property(int houseNumber, String street, String city,
                    String postCode, int numberOfRooms)
            throws IllegalArgumentException, NullPointerException {
        super();
        if (this.nullCheck(street, city, postCode)) {
            throw new NullPointerException("Street, city and"
                    + " post code must not be null");
        }
        if (houseNumber <= 0) {
            throw new IllegalArgumentException("House number"
                    + " should be positive");
        }
        if (!this.validateCity(city)) {
            throw new IllegalArgumentException("City must"
                    + " start with a capital letter");
        }
        if (!this.validatePostCode(postCode
                .replace(" ", ""))) {
            throw new IllegalArgumentException("Post code"
                    + " must be in the format GU00XX or GU0 0XX");
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
     * Gets the number of rooms available in the property.
     *
     * @return the number of rooms available in the property
     */
    public int getAvailableRooms() {
        return this.numberOfRooms - this.rooms.size();
    }

    /**
     * Gets the council tax for the property.
     *
     * @return the council tax for the property
     */
    public double getCouncilTax() {
        return this.councilTax;
    }

    /**
     * Sets the council tax for the property.
     *
     * @param tax the council tax for the property
     */
    public void setCouncilTax(double tax) {
        int students = (int) this.rooms.values().stream().filter(t ->
                t.getType().equals(TenantType.STUDENT)).count();

        int professional = (int) this.rooms.values().stream().filter(t ->
                t.getType().equals(TenantType.PROFESSIONAL)).count();

        double multiplier = 0;

        if (professional == 1) {
            multiplier = 0.75;
        } else if (students == 0) {
            multiplier = 1;
        }
        this.councilTax = tax * multiplier;
    }

    /**
     * Gets the number of rooms in the property.
     *
     * @return the number of rooms in the property
     */
    public int getNumberOfRooms() {
        return this.numberOfRooms;
    }

    /**
     * Gets the price of all the rooms in the property.
     *
     * @return the sum of price of all the rooms in the property
     */
    public abstract double getPrice();

    /**
     * Checks if the property has at least one room available.
     *
     * @return true if there is at least one room available in the property
     */
    public abstract boolean isAvailable();

    /**
     * Occupies a room in the property with a tenant.
     *
     * @param r the room to occupy
     * @param t the tenant
     * @throws IllegalArgumentException if the room is already occupied
     *                                  or if the property is full
     * @throws NullPointerException     if the room or tenant is null
     */
    public abstract void occupy(Room r, ITenant t)
            throws IllegalArgumentException, NullPointerException;

    /**
     * Displays all the rooms and total of the property.
     *
     * @return string containing all the rooms and total of the property
     */
    public abstract String displayOccupiedProperty();

    @Override
    public String toString() {
        return String.format("%d %s, %s %s (%d bedroom ",
                this.houseNumber, this.street, this.city,
                this.postCode, this.numberOfRooms);
    }

    private boolean validateCity(String city) {
        return city != null && city.matches(CITY_REGEX);
    }

    private boolean validatePostCode(String postCode) {
        return postCode != null && postCode.matches(POSTCODE_REGEX);
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
