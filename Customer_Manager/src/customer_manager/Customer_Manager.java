/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customer_manager;
/*
@thabo mhlongo
05HA2310394
Boston College
*/
import java.sql.*;
import java.util.Scanner;

public class Customer_Manager {
    // Database connection link and login details
    private static final String URL = "jdbc:mysql://localhost:3306/shop_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Configuration29@";

    private Connection conn;
    private Scanner scanner;

    public Customer_Manager() {
        //inputing customer details
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Customer_Manager app = new Customer_Manager();
        app.run();
    }

    public void run() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to shop_db database.");

            int choice;
            while (true) {
                showMenu();
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid entry. Please enter a number (1-3).\n");
                    continue;
                }
                //hre optins using switch 
                switch (choice) {
                    case 1:
                        insertCustomer();
                        break;
                    case 2:
                        viewCustomers();
                        break;
                    case 3:
                        System.out.println("Exiting program. Goodbye!");
                        closeResources();
                        return;
                    default:
                        System.out.println("Choice out of range. Please select 1, 2, or 3.\n");
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error connecting to the database.");
            e.printStackTrace();
        }
    }

    private void showMenu() {
        System.out.println("\n=== Customer Management ===");
        System.out.println("1. Insert Customer");
        System.out.println("2. View All Customers");
        System.out.println("3. Exit");
        System.out.println("===== Options =====");
        System.out.print("Enter your choice (1-3): ");
    }

    private void insertCustomer() {
        try {
            String name = promptNonEmpty("Enter customer name: ");
            String email = promptValidEmail("Enter customer email: ");

            String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);

            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "Customer inserted successfully." : "Failed to insert customer.");
        } catch (SQLException e) {
            System.err.println("Error inserting customer record.");
            e.printStackTrace();
        }
    }

    private void viewCustomers() {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT customerID, name, email FROM customers")) {

            System.out.println("\n--- Customer List ---");
            if (!rs.isBeforeFirst()) {
                System.out.println("No customers found.");
            }
            while (rs.next()) {
                int id = rs.getInt("customerID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.printf("ID: %d | Name: %s | Email: %s%n", id, name, email);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving customer records.");
            e.printStackTrace();
        }
    }

    private String promptNonEmpty(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private String promptValidEmail(String prompt) {
        String email;
        while (true) {
            System.out.print(prompt);
            email = scanner.nextLine().trim();
            if (email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) {
                return email;
            }
            System.out.println("Invalid email format. Please enter a valid email address.");
        }
    }

    private void closeResources() {
        try {
            if (conn != null && !conn.isClosed()) conn.close();
            if (scanner != null) scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
