package Question_2;

public class Room {
    private double price = 0.0;

    public Room(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Room: %.1f", this.price);
    }
}
