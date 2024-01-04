package Question_2;

public class Room {
    private double price = 0.0;

    /**
     * Creates a new room.
     *
     * @param price the price of the room
     */
    public Room(double price) {
        super();
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("Room: %.1f", this.price);
    }
}
