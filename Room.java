/**
 * Room class represents a type of room in the hotel
 */
public class Room {

    private String type;
    private double price;
    private int availableRooms;

    public Room(String type, double price, int availableRooms) {
        this.type = type;
        this.price = price;
        this.availableRooms = availableRooms;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }
}