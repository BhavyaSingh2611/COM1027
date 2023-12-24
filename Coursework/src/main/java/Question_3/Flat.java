package Question_3;

public class Flat extends Property {
    private static final double MAINTENANCE_COSTS = 500;
    private int floor = 0;

    public Flat(int houseNumber, String street, String city, String postCode, int numberOfRooms, int floor) throws IllegalArgumentException, NullPointerException {
        super(houseNumber, street, city, postCode, numberOfRooms);
        if (floor < 0) {
            throw new IllegalArgumentException("Floor should be positive");
        }
        this.floor = floor;
    }

    //TODO: Confirm from the discussion forum that the following method is correct
    @Override
    public int getAvailableRooms() {
        return this.isAvailable() ? super.getAvailableRooms() : 0;
    }

    @Override
    public double getPrice() {
        return this.rooms.keySet().stream().mapToDouble(Room::getPrice).sum();
    }

    @Override
    public boolean isAvailable() {
        return this.rooms.isEmpty();
    }

    @Override
    public void occupy(Room p, ITenant t) {
        if (p == null || t == null) {
            throw new IllegalArgumentException("Room and tenant must not be null");
        }
        if (this.rooms.containsKey(p)) {
            throw new IllegalArgumentException("Room is already occupied");
        }
        if (!this.isAvailable()) {
            throw new IllegalArgumentException("Flat is full");
        }
        if (!t.getTenantType().equals(TenantType.PROFESSIONAL)) {
            System.out.println("Only professionals can rent flats");
            return;
        }
        this.rooms.put(p, t);
    }

    @Override
    public String displayOccupiedProperty() {
        StringBuilder output = new StringBuilder(this.toString()).append("\n");
        for (Room r : this.rooms.keySet()) {
            output.append(String.format("\t%s\n", r.toString()));
        }
        // TODO: Also correct this function if they say not to override
        double price = (this.getPrice() * 12 * super.getAvailableRooms()) + MAINTENANCE_COSTS;
        output.append(String.format("\tTotal: £%.2f (Council Tax: £%.1f)\n", price, this.getCouncilTax()));

        return output.toString();
    }

    @Override
    public String toString() {
        int availableRooms = this.isAvailable() ? this.getAvailableRooms() : 0;
        return super.toString() + String.format("flat on %d floor :%d available)", this.floor, availableRooms);
    }
}
