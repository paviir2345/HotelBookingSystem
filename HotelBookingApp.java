import java.util.Scanner;

public class HotelBookingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("====================================");
        System.out.println("   HOTEL BOOKING MANAGEMENT SYSTEM  ");
        System.out.println("====================================");
        System.out.println("Version: 1.2");

        while (running) {

            System.out.println("\nSelect an option:");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Displaying available rooms...");
                    break;

                case 2:
                    System.out.println("Booking feature coming soon...");
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