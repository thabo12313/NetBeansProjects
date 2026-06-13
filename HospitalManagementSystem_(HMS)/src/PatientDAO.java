/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thabo
 */
import java.sql.*;
import java.time.LocalDate;

public class PatientDAO {
    /**
     * Inserts a new patient record into the PATIENTS table.
     */
    public void insertPatient(String firstName, String lastName, LocalDate dob, String gender,
                              String phone, String address, LocalDate admissionDate) {
        String sql = "INSERT INTO PATIENTS (FirstName, LastName, DOB, Gender, Phone, Address, AdmissionDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setDate(3, Date.valueOf(dob));
            stmt.setString(4, gender);
            stmt.setString(5, phone);
            stmt.setString(6, address);
            stmt.setDate(7, Date.valueOf(admissionDate));
            stmt.executeUpdate();
            System.out.println("Patient inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a patient record by PatientID.
     */
    public void getPatientById(int patientId) {
        String sql = "SELECT * FROM PATIENTS WHERE PatientID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, patientId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Patient ID: " + rs.getInt("PatientID"));
                System.out.println("Name: " + rs.getString("FirstName") + " " + rs.getString("LastName"));
                System.out.println("DOB: " + rs.getDate("DOB"));
                System.out.println("Gender: " + rs.getString("Gender"));
                System.out.println("Phone: " + rs.getString("Phone"));
                System.out.println("Address: " + rs.getString("Address"));
                System.out.println("Admission Date: " + rs.getDate("AdmissionDate"));
            } else {
                System.out.println("Patient not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates a patient's phone and address based on their ID.
     */
    public void updatePatient(int patientId, String phone, String address) {
        String sql = "UPDATE PATIENTS SET Phone = ?, Address = ? WHERE PatientID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, phone);
            stmt.setString(2, address);
            stmt.setInt(3, patientId);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Patient updated successfully." : "Patient not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a patient record based on PatientID.
     */
    public void deletePatient(int patientId) {
        String sql = "DELETE FROM PATIENTS WHERE PatientID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, patientId);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Patient deleted successfully." : "Patient not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
