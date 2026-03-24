import java.util.Scanner;

/**
 * Hotel Booking Management System
 * UC2: Menu System & User Interaction
 *
 * @author Pavithra
 * @version 1.1
 */
public class HotelBookingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Welcome Message (from UC1)
        System.out.println("====================================");
        System.out.println("   HOTEL BOOKING MANAGEMENT SYSTEM  ");
        System.out.println("====================================");
        System.out.println("Version: 1.1");

        // Menu Options
        System.out.println("\nSelect an option:");
        System.out.println("1. View Rooms");
        System.out.println("2. Book Room");
        System.out.println("3. Exit");

        // User Input
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        // Decision Logic
        switch (choice) {
            case 1:
                System.out.println("Displaying available rooms...");
                break;

            case 2:
                System.out.println("Booking feature coming soon...");
                break;

            case 3:
                System.out.println("Exiting application...");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }
}