import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdminDAO adminDao = new AdminDAO();
        StudentDAO studentDao = new StudentDAO();

        // Admin Login
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("===== ADMIN LOGIN =====");
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            if (adminDao.login(username, password)) {
                System.out.println("✅ Login Successful!\n");
                loggedIn = true;
            } else {
                System.out.println("❌ Invalid credentials. Try again.\n");
            }
        }

        // Menu
        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> studentDao.addStudent();
                case 2 -> studentDao.viewStudents();
                case 3 -> studentDao.updateStudent();
                case 4 -> studentDao.deleteStudent();
                case 5 -> studentDao.searchStudent();
                case 6 -> {
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid choice. Try again!");
            }
        }
    }
}
