/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customermanagerfa3;

/**
 *
 * @author thabo
 */
import java.sql.*;
import java.util.Scanner;


public class CustomerManagerFA3 {
    private static final String URL = "jdbc:mysql://localhost:3306/shop_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Configuration29@";

    
    
public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); 
                Scanner scanner = new Scanner(System.in)){
            
                    int choice;
                    do {
                        System.out.println("===== Customer Management Menu =====");
                        System.out.println("1. Insert a customer");
                        System.out.println("2. View all customers");
                        System.out.println("3. Exit");
                        System.out.print("Enter choice: ");
                        choice = scanner.nextInt();
                        scanner.nextLine();  // consume newline
                        
                        switch(choice){
                            case 1:
                                insertCustomer(conn, scanner);
                                break;
                            case 2: viewAllCustomers(conn);
                                break;
                            case 3:
                                System.out.println("Exiting program. Goodbye!");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                                
                        } while (choice != 3);
                    conn.close();
        }catch(SQLException e){
            System.err.println("Database error: "+ e.getMessage());
        }
    }
              
private static void insertCustomer(Connection conn, Scanner scanner){
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Customer inserted successfully.");
            } else {
                System.out.println("Insert failed.");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting customer: " + e.getMessage());
        }

}

private static void viewAllCustomers(Connection conn) {
        String sql = "SELECT id, name, email FROM customers";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Customer Records ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.printf("ID: %d, Name: %s, Email: %s%n", id, name, email);
            }
            System.out.println();

        } catch (SQLException e) {
            System.err.println("Error retrieving customers: " + e.getMessage());
        }
    }
                
}
