package Question_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Property {
    private int houseNumber = 0;
    private String street = null;
    private String city = null;
    private String postCode = null;
    private int numberOfRooms = 0;
    private List<Complaint> complaints = null;
    protected Map<Room, ITenant> rooms = null;
    protected double councilTax = 0;
    private static final String CITY_REGEX = "^[A-Z][a-z]*";
    private static final String POSTCODE_REGEX = "GU\\d{2}[A-Z]{2}$";


    public Property(int houseNumber, String street, String city, String postCode, int numberOfRooms)
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
        this.complaints = new ArrayList<Complaint>();
    }

    public void addComplaint(Complaint complaint) {
        this.complaints.add(complaint);
    }

    public int calculateImpact() {
        return this.complaints.stream().mapMultiToInt((complaint, consumer) ->
                consumer.accept(complaint.getSeverity().getWeight())).sum();
    }

    public int getAvailableRooms() {
        return this.numberOfRooms - this.rooms.size();
    }

    public double getCouncilTax() {
        return this.councilTax;
    }

    public void setCouncilTax(double councilTax) {
        int students = (int) rooms.values().stream().filter(t ->
                t.getTenantType().equals(TenantType.STUDENT)).count();

        int professional = (int) rooms.values().stream().filter(t ->
                t.getTenantType().equals(TenantType.PROFESSIONAL)).count();

        double multiplier = 0;

        if (professional == 1) {
            multiplier = 0.75;
        } else if (students == 0) {
            multiplier = 1;
        }
        this.councilTax = councilTax * multiplier;
    }

    public abstract double getPrice();

    public abstract boolean isAvailable();

    public abstract void occupy(Room p, ITenant t);

    public abstract String displayOccupiedProperty();

    @Override
    public String toString() {
        return String.format("%d %s, %s %s (%d bedroom ", this.houseNumber, this.street, this.city,
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
