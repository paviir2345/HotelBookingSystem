import java.util.*;

/**
 * Hotel Booking System
 * UC1 → UC7 Implementation
 */
public class HotelBookingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Inventory
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        // Prices
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Single", 1000);
        prices.put("Double", 2000);
        prices.put("Suite", 5000);

        // UC5: Booking Queue
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // UC6: Allocation
        Set<String> allocatedRoomIds = new HashSet<>();
        Map<String, Set<String>> roomAllocations = new HashMap<>();

        // 🔥 UC7: Add-on Services (Reservation → Services)
        Map<String, List<Service>> reservationServices = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== Hotel Booking System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room (Add to Queue)");
            System.out.println("3. Process Booking (Allocate Room)");
            System.out.println("4. Add Services to Reservation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                // UC4
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

                // UC5
                case 2:
                    scanner.nextLine();

                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String roomType = scanner.nextLine();

                    bookingQueue.add(new Reservation(name, roomType));
                    System.out.println("Booking request added to queue.");
                    break;

                // UC6
                case 3:

                    if (bookingQueue.isEmpty()) {
                        System.out.println("No booking requests.");
                        break;
                    }

                    Reservation req = bookingQueue.poll();
                    String type = req.getRoomType();

                    if (!inventory.containsKey(type) || inventory.get(type) <= 0) {
                        System.out.println("No rooms available.");
                        break;
                    }

                    // Generate unique ID
                    String roomId;
                    do {
                        roomId = type.substring(0, 1).toUpperCase() + (int)(Math.random() * 1000);
                    } while (allocatedRoomIds.contains(roomId));

                    allocatedRoomIds.add(roomId);

                    roomAllocations.putIfAbsent(type, new HashSet<>());
                    roomAllocations.get(type).add(roomId);

                    inventory.put(type, inventory.get(type) - 1);

                    System.out.println("\nBooking Confirmed!");
                    System.out.println("Guest: " + req.getGuestName());
                    System.out.println("Room ID: " + roomId);

                    break;

                // 🔥 UC7: Add Services
                case 4:
                    scanner.nextLine();

                    System.out.print("Enter Reservation ID (Room ID): ");
                    String resId = scanner.nextLine();

                    // Create list if not exists
                    reservationServices.putIfAbsent(resId, new ArrayList<>());

                    System.out.println("Select Service:");
                    System.out.println("1. Food (₹500)");
                    System.out.println("2. Laundry (₹300)");
                    System.out.println("3. Spa (₹1000)");

                    int serviceChoice = scanner.nextInt();

                    Service service = null;

                    switch (serviceChoice) {
                        case 1:
                            service = new Service("Food", 500);
                            break;
                        case 2:
                            service = new Service("Laundry", 300);
                            break;
                        case 3:
                            service = new Service("Spa", 1000);
                            break;
                        default:
                            System.out.println("Invalid service");
                            break;
                    }

                    if (service != null) {
                        reservationServices.get(resId).add(service);
                        System.out.println("Service added successfully!");
                    }

                    // Show total cost
                    int total = 0;
                    for (Service s : reservationServices.get(resId)) {
                        total += s.getCost();
                    }

                    System.out.println("Total Service Cost: ₹" + total);

                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        scanner.close();
    }
}