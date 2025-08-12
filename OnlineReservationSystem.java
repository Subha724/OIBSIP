import java.util.*;

class OnlineReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static String loginId = "Subha@123";
    static String password = "pass@123";
    static Map<String, String> reservations = new HashMap<>();

    public static void main(String[] args) {
        if (login()) {
            while (true) {
                System.out.println("1. Reservation\n2. Cancellation\n3. Exit");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) reservation();
                else if (choice == 2) cancellation();
                else break;
            }
        } else {
            System.out.println("Invalid login.");
        }
    }

    static boolean login() {
        System.out.print("Enter Login ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        return id.equals(loginId) && pass.equals(password);
    }

    static void reservation() {
        System.out.print("Enter PNR Number: ");
        String pnr = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Train Number: ");
        String trainNumber = sc.nextLine();
        System.out.print("Enter Train Name: ");
        String trainName = sc.nextLine();
        System.out.print("Enter Class Type: ");
        String classType = sc.nextLine();
        System.out.print("Enter Date of Journey: ");
        String date = sc.nextLine();
        System.out.print("From: ");
        String from = sc.nextLine();
        System.out.print("To: ");
        String to = sc.nextLine();
        reservations.put(pnr, name + ", " + trainNumber + ", " + trainName + ", " + classType + ", " + date + ", " + from + " to " + to);
        System.out.println("Reservation Successful.");
    }

    static void cancellation() {
        System.out.print("Enter PNR Number: ");
        String pnr = sc.nextLine();
        if (reservations.containsKey(pnr)) {
            System.out.println("Details: " + reservations.get(pnr));
            System.out.print("Confirm cancellation? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) {
                reservations.remove(pnr);
                System.out.println("Cancellation Successful.");
            } else {
                System.out.println("Cancellation Aborted.");
            }
        } else {
            System.out.println("PNR Not Found.");
 }
}
}