/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thabo
 */
import java.sql.*;

/**
 * Data Access Object (DAO) class for managing DOCTORS table.
 */
public class DoctorDAO {

    /**
     * Inserts a new doctor record into the DOCTORS table.
     */
    public void insertDoctor(String firstName, String lastName, String specialty,
                             String phone, String email) {
        String sql = "INSERT INTO DOCTORS (FirstName, LastName, Specialty, Phone, Email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, specialty);
            stmt.setString(4, phone);
            stmt.setString(5, email);
            stmt.executeUpdate();
            System.out.println("Doctor inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a doctor record by DoctorID.
     */
    public void getDoctorById(int doctorId) {
        String sql = "SELECT * FROM DOCTORS WHERE DoctorID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, doctorId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Doctor ID: " + rs.getInt("DoctorID"));
                System.out.println("Name: " + rs.getString("FirstName") + " " + rs.getString("LastName"));
                System.out.println("Specialty: " + rs.getString("Specialty"));
                System.out.println("Phone: " + rs.getString("Phone"));
                System.out.println("Email: " + rs.getString("Email"));
            } else {
                System.out.println("Doctor not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates a doctor's phone and email based on their ID.
     */
    public void updateDoctor(int doctorId, String phone, String email) {
        String sql = "UPDATE DOCTORS SET Phone = ?, Email = ? WHERE DoctorID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, phone);
            stmt.setString(2, email);
            stmt.setInt(3, doctorId);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Doctor updated successfully." : "Doctor not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a doctor record based on DoctorID.
     */
    public void deleteDoctor(int doctorId) {
        String sql = "DELETE FROM DOCTORS WHERE DoctorID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, doctorId);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Doctor deleted successfully." : "Doctor not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

