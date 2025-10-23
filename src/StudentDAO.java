import java.sql.*;
import java.util.Scanner;

public class StudentDAO {
    Connection conn = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);

    // Add Student
    public void addStudent() {
        try {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Course: ");
            String course = sc.nextLine();
            System.out.print("Enter Grade: ");
            String grade = sc.nextLine();

            String sql = "INSERT INTO students(name, age, course, grade) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, grade);
            ps.executeUpdate();
            System.out.println("✅ Student added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Students
    public void viewStudents() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            System.out.println("\nID | Name | Age | Course | Grade");
            System.out.println("----------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getInt("age") + " | " +
                                   rs.getString("course") + " | " +
                                   rs.getString("grade"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Student
    public void updateStudent() {
        try {
            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            System.out.print("Enter New Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter New Course: ");
            String course = sc.nextLine();
            System.out.print("Enter New Grade: ");
            String grade = sc.nextLine();

            String sql = "UPDATE students SET name=?, age=?, course=?, grade=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, grade);
            ps.setInt(5, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("✅ Student updated successfully!");
            else System.out.println("❌ Student ID not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("✅ Student deleted successfully!");
            else System.out.println("❌ Student ID not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search by Name
    public void searchStudent() {
        try {
            System.out.print("Enter Student Name to search: ");
            String name = sc.nextLine();
            String sql = "SELECT * FROM students WHERE name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            System.out.println("\nID | Name | Age | Course | Grade");
            System.out.println("----------------------------------");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getInt("age") + " | " +
                                   rs.getString("course") + " | " +
                                   rs.getString("grade"));
            }
            if (!found) System.out.println("❌ No student found with that name.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
