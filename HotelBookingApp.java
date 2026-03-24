import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hotel Booking Management System
 * UC4: Room Search & Availability Check
 *
 * @author Pavithra
 * @version 1.3
 */
public class HotelBookingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Inventory (Room Data)
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Single Room", 1000, 5));
        rooms.add(new Room("Double Room", 2000, 3));
        rooms.add(new Room("Suite", 5000, 0)); // Not available

        // Welcome Message
        System.out.println("====================================");
        System.out.println("   HOTEL BOOKING MANAGEMENT SYSTEM  ");
        System.out.println("====================================");
        System.out.println("Version: 1.3");

        while (running) {

            System.out.println("\nSelect an option:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    // UC4 LOGIC (Read-only search)
                    System.out.println("\nAvailable Rooms:");

                    for (Room room : rooms) {
                        if (room.getAvailableRooms() > 0) {
                            System.out.println("Type: " + room.getType());
                            System.out.println("Price: ₹" + room.getPrice());
                            System.out.println("Available: " + room.getAvailableRooms());
                            System.out.println("----------------------");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Booking feature coming in next UC...");
                    break;

                case 3:
                    System.out.println("Exiting application...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}