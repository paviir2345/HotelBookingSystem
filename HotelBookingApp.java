import java.util.*;

/**
 * Hotel Booking System
 * UC1 → UC6 Implementation
 */
public class HotelBookingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Inventory (Room Availability)
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        // Room Prices
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Single", 1000);
        prices.put("Double", 2000);
        prices.put("Suite", 5000);

        // UC5: Booking Queue (FIFO)
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // UC6: Unique Room Allocation
        Set<String> allocatedRoomIds = new HashSet<>();
        Map<String, Set<String>> roomAllocations = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== Hotel Booking System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room (Add to Queue)");
            System.out.println("3. Process Booking (Allocate Room)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                // UC4: View Rooms (Read-only)
                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (String type : inventory.keySet()) {
                        int count = inventory.get(type);

                        if (count > 0) {
                            System.out.println(type + " | Available: " + count +
                                    " | Price: ₹" + prices.get(type));
                        }
                    }
                    break;

                // UC5: Add Booking Request to Queue
                case 2:
                    scanner.nextLine(); // clear buffer

                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String roomType = scanner.nextLine();

                    Reservation reservation = new Reservation(name, roomType);
                    bookingQueue.add(reservation);

                    System.out.println("Booking request added to queue.");

                    System.out.println("\nCurrent Queue:");
                    for (Reservation r : bookingQueue) {
                        System.out.println(r.getGuestName() + " -> " + r.getRoomType());
                    }
                    break;

                // UC6: Process Booking & Allocate Room
                case 3:

                    if (bookingQueue.isEmpty()) {
                        System.out.println("No booking requests in queue.");
                        break;
                    }

                    // FIFO
                    Reservation req = bookingQueue.poll();
                    String type = req.getRoomType();

                    // Check availability
                    if (!inventory.containsKey(type) || inventory.get(type) <= 0) {
                        System.out.println("No rooms available for " + type);
                        break;
                    }

                    // Generate unique Room ID
                    String roomId;
                    do {
                        roomId = type.substring(0, 1).toUpperCase() + (int)(Math.random() * 1000);
                    } while (allocatedRoomIds.contains(roomId));

                    // Store unique ID
                    allocatedRoomIds.add(roomId);

                    // Map room type → allocated rooms
                    roomAllocations.putIfAbsent(type, new HashSet<>());
                    roomAllocations.get(type).add(roomId);

                    // Update inventory
                    inventory.put(type, inventory.get(type) - 1);

                    // Confirmation
                    System.out.println("\nBooking Confirmed!");
                    System.out.println("Guest: " + req.getGuestName());
                    System.out.println("Room Type: " + type);
                    System.out.println("Room ID: " + roomId);

                    break;

                case 4:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        scanner.close();
    }
}