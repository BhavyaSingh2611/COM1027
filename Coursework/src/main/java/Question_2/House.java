package Question_2;

public class House extends Property {
    public House(int houseNumber, String street, String city, String postCode, int numberOfRooms) throws IllegalArgumentException, NullPointerException {
        super(houseNumber, street, city, postCode, numberOfRooms);
    }

    @Override
    public double getPrice() {
        return this.rooms.keySet().stream().mapToDouble(Room::getPrice).sum();
    }

    @Override
    public boolean isAvailable() {
        return this.getAvailableRooms() > 0;
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
            throw new IllegalArgumentException("House is full");
        }
        this.rooms.put(p, t);
    }

    @Override
    public String displayOccupiedProperty() {
        StringBuilder output = new StringBuilder(this.toString()).append("\n");
        for (Room r : this.rooms.keySet()) {
            output.append(String.format("\t%s\n", r.toString()));
        }
        double price = (this.getPrice() * 12);
        output.append(String.format("\tTotal: £%.2f (Council Tax: £%.1f)\n", price, this.getCouncilTax()));

        return output.toString();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("house :%d available)", this.getAvailableRooms());
    }
}
