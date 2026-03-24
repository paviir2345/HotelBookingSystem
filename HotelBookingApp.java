import java.util.*;

/**
 * Hotel Booking System
 * Version: 1.0
 * UC1 → UC5 Implementation
 */
public class HotelBookingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Room Data (UC4)
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        // Room Prices
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Single", 1000);
        prices.put("Double", 2000);
        prices.put("Suite", 5000);

        // Booking Queue (UC5)
        Queue<Reservation> bookingQueue = new LinkedList<>();

        int choice;

        do {
            // UC2 Menu
            System.out.println("\n===== Hotel Booking System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room (Add to Queue)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                // UC4 – Room Search
                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (String type : inventory.keySet()) {
                        int count = inventory.get(type);

                        // Show only available rooms
                        if (count > 0) {
                            System.out.println(type + " | Available: " + count +
                                    " | Price: ₹" + prices.get(type));
                        }
                    }
                    break;

                // UC5 – Booking Request Queue
                case 2:
                    scanner.nextLine(); // clear buffer

                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String roomType = scanner.nextLine();

                    // Create Reservation
                    Reservation reservation = new Reservation(name, roomType);

                    // Add to Queue
                    bookingQueue.add(reservation);

                    System.out.println("Booking request added to queue.");

                    // Show Queue (for understanding FIFO)
                    System.out.println("\nCurrent Booking Queue:");
                    for (Reservation r : bookingQueue) {
                        System.out.println(r.getGuestName() + " -> " + r.getRoomType());
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        scanner.close();
    }
}