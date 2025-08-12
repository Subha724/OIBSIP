import java.util.*;

class DigitalLibrary {
    static Scanner sc = new Scanner(System.in);
    static Map<String, String> books = new HashMap<>();
    static String adminId = "Subha";
    static String adminPass = "Subha@321";

    public static void main(String[] args) {
        books.put("B001", "Java Programming");
        books.put("B002", "Python Basics");
        books.put("B003", "Data Structures");

        System.out.println("1. Admin\n2. User");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) adminLogin();
        else if (choice == 2) userMenu();
        else System.out.println("Invalid choice");
    }

    static void adminLogin() {
        System.out.print("Enter Admin ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        if (id.equals(adminId) && pass.equals(adminPass)) adminMenu();
        else System.out.println("Invalid Login");
    }

    static void adminMenu() {
        while (true) {
            System.out.println("1. Add Book\n2. Update Book\n3. Delete Book\n4. View Books\n5. Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                System.out.print("Enter Book ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Book Name: ");
                String name = sc.nextLine();
                books.put(id, name);
            } else if (ch == 2) {
                System.out.print("Enter Book ID: ");
                String id = sc.nextLine();
                if (books.containsKey(id)) {
                    System.out.print("Enter New Book Name: ");
                    books.put(id, sc.nextLine());
                } else System.out.println("Book not found");
            } else if (ch == 3) {
                System.out.print("Enter Book ID: ");
                books.remove(sc.nextLine());
            } else if (ch == 4) viewBooks();
            else break;
        }
    }

    static void userMenu() {
        while (true) {
            System.out.println("1. View Books\n2. Search Book\n3. Issue Book\n4. Return Book\n5. Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) viewBooks();
            else if (ch == 2) {
                System.out.print("Enter Book Name to Search: ");
                String name = sc.nextLine();
                books.entrySet().stream()
                     .filter(e -> e.getValue().equalsIgnoreCase(name))
                     .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
            } else if (ch == 3) {
                System.out.print("Enter Book ID to Issue: ");
                String id = sc.nextLine();
                if (books.containsKey(id)) {
                    System.out.println("Book Issued: " + books.get(id));
                } else System.out.println("Book not found");
            } else if (ch == 4) {
                System.out.print("Enter Book ID to Return: ");
                String id = sc.nextLine();
                if (books.containsKey(id)) {
                    System.out.println("Book Returned: " + books.get(id));
                } else System.out.println("Invalid Book ID");
            } else break;
        }
    }

    static void viewBooks() {
        books.forEach((id, name) -> System.out.println(id + ": " +name));
}
}