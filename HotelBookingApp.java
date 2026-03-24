import java.util.Scanner;

/**
 * Hotel Booking Management System
 * UC3: Continuous Execution using While Loop
 *
 * @author Pavithra
 * @version 1.2
 */
public class HotelBookingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Welcome Message
        System.out.println("====================================");
        System.out.println("   HOTEL BOOKING MANAGEMENT SYSTEM  ");
        System.out.println("====================================");
        System.out.println("Version: 1.2");

        // Loop starts
        while (running) {

            // Menu
            System.out.println("\nSelect an option:");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");

            // Input
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Logic
            switch (choice) {
                case 1:
                    System.out.println("Displaying available rooms...");
                    break;

                case 2:
                    System.out.println("Booking feature coming soon...");
                    break;

                case 3:
                    System.out.println("Exiting application...");
                    running = false; // stops loop
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}