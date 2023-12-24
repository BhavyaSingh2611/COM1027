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
    private static final String POSTCODE_REGEX = "GU\\d{2}[A-Z]{2}$";


    public House(int houseNumber, String street, String city, String postCode, int numberOfRooms)
            throws IllegalArgumentException, NullPointerException {
        if (this.nullCheck(street, city, postCode)) {
            throw new NullPointerException("Street, city and post code must not be null");
        }
        if (houseNumber < 0) {
            throw new IllegalArgumentException("House number should be positive");
        }
        if (!this.validateCity(city)) {
            throw new IllegalArgumentException("City must start with a capital letter");
        }
        if (!this.validatePostCode(postCode.replace(" ", ""))) {
            throw new IllegalArgumentException("Post code must be in the format GU00XX or GU0 0XX");
        }
        if (numberOfRooms < 1) {
            throw new IllegalArgumentException("Number of rooms must be at least 1");
        }

        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.numberOfRooms = numberOfRooms;
        this.rooms = new HashMap<Room, ITenant>();
    }

    public int getAvailableRooms() {
        return this.numberOfRooms - this.rooms.size();
    }

    public double getPrice() {
        return this.rooms.keySet().stream().mapToDouble(Room::getPrice).sum();
    }

    public boolean isAvailable() {
        return this.getAvailableRooms() > 0;
    }

    public void occupy(Room p, ITenant t) {
        if (p == null || t == null) {
            throw new IllegalArgumentException("Room and tenant must not be null");
        }
        if (this.rooms.containsKey(p)) {
            throw new IllegalArgumentException("Room is already occupied");
        }
        if (!this.isAvailable()) {
            throw new IllegalArgumentException("House is full");
        }
        this.rooms.put(p, t);
    }

    @Override
    public String toString() {
        return String.format("%d %s, %s %s (%d bedroom house :%d available)", this.houseNumber, this.street, this.city,
                this.postCode, this.numberOfRooms, this.getAvailableRooms());
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
