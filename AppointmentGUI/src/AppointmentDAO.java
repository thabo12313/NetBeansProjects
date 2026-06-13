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
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public void insertAppointment(int patientId, int doctorId, LocalDate date, String description) throws SQLException {
        String sql = "INSERT INTO APPOINTMENTS (PatientID, DoctorID, AppointmentDate, Description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, patientId);
            stmt.setInt(2, doctorId);
            stmt.setDate(3, Date.valueOf(date));
            stmt.setString(4, description);
            stmt.executeUpdate();
        }
    }

    public void updateAppointment(int appointmentId, LocalDate date, String description) throws SQLException {
        String sql = "UPDATE APPOINTMENTS SET AppointmentDate = ?, Description = ? WHERE AppointmentID = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(date));
            stmt.setString(2, description);
            stmt.setInt(3, appointmentId);
            stmt.executeUpdate();
        }
    }

    public void deleteAppointment(int appointmentId) throws SQLException {
        String sql = "DELETE FROM APPOINTMENTS WHERE AppointmentID = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, appointmentId);
            stmt.executeUpdate();
        }
    }

    public List<String[]> getAllAppointments() throws SQLException {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT * FROM APPOINTMENTS";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new String[]{
                    String.valueOf(rs.getInt("AppointmentID")),
                    String.valueOf(rs.getInt("PatientID")),
                    String.valueOf(rs.getInt("DoctorID")),
                    rs.getDate("AppointmentDate").toString(),
                    rs.getString("Description")
                });
            }
        }
        return list;
    }
}

