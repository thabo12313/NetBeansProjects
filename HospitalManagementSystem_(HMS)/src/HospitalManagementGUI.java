/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author thabo
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.sql.*;

public class HospitalManagementGUI extends JFrame {
    private JTextField txtFirstName, txtLastName, txtDOB, txtGender, txtPhone, txtAddress, txtAdmissionDate;
    private JButton btnAdd, btnUpdate, btnDelete;
    private JTable table;
    private DefaultTableModel model;
    private int selectedPatientId = -1;

    public HospitalManagementGUI() {
        setTitle("Hospital Management System - Patients");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout setup
        JPanel panel = new JPanel(new GridLayout(10, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Patient Information"));

        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtDOB = new JTextField();
        txtGender = new JTextField();
        txtPhone = new JTextField();
        txtAddress = new JTextField();
        txtAdmissionDate = new JTextField();

        panel.add(new JLabel("First Name:"));
        panel.add(txtFirstName);
        panel.add(new JLabel("Last Name:"));
        panel.add(txtLastName);
        panel.add(new JLabel("DOB (yyyy-mm-dd):"));
        panel.add(txtDOB);
        panel.add(new JLabel("Gender:"));
        panel.add(txtGender);
        panel.add(new JLabel("Phone:"));
        panel.add(txtPhone);
        panel.add(new JLabel("Address:"));
        panel.add(txtAddress);
        panel.add(new JLabel("Admission Date (yyyy-mm-dd):"));
        panel.add(txtAdmissionDate);

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);

        // Table
        model = new DefaultTableModel(new String[]{"ID", "First Name", "Last Name", "DOB", "Gender", "Phone", "Address", "Admission Date"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Load data
        loadPatients();

        // Listeners
        btnAdd.addActionListener(e -> addPatient());
        btnUpdate.addActionListener(e -> updatePatient());
        btnDelete.addActionListener(e -> deletePatient());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                selectedPatientId = Integer.parseInt(model.getValueAt(row, 0).toString());
                txtFirstName.setText(model.getValueAt(row, 1).toString());
                txtLastName.setText(model.getValueAt(row, 2).toString());
                txtDOB.setText(model.getValueAt(row, 3).toString());
                txtGender.setText(model.getValueAt(row, 4).toString());
                txtPhone.setText(model.getValueAt(row, 5).toString());
                txtAddress.setText(model.getValueAt(row, 6).toString());
                txtAdmissionDate.setText(model.getValueAt(row, 7).toString());
            }
        });
    }

    private void loadPatients() {
        model.setRowCount(0);
        String sql = "SELECT * FROM PATIENTS";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("PatientID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getDate("DOB"),
                    rs.getString("Gender"),
                    rs.getString("Phone"),
                    rs.getString("Address"),
                    rs.getDate("AdmissionDate")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addPatient() {
        try {
            PatientDAO dao = new PatientDAO();
            dao.insertPatient(
                    txtFirstName.getText(),
                    txtLastName.getText(),
                    LocalDate.parse(txtDOB.getText()),
                    txtGender.getText(),
                    txtPhone.getText(),
                    txtAddress.getText(),
                    LocalDate.parse(txtAdmissionDate.getText())
            );
            loadPatients();
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding patient: " + ex.getMessage());
        }
    }

    private void updatePatient() {
        if (selectedPatientId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a patient to update.");
            return;
        }
        try {
            PatientDAO dao = new PatientDAO();
            dao.updatePatient(selectedPatientId, txtPhone.getText(), txtAddress.getText());
            loadPatients();
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating patient: " + ex.getMessage());
        }
    }

    private void deletePatient() {
        if (selectedPatientId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a patient to delete.");
            return;
        }
        try {
            PatientDAO dao = new PatientDAO();
            dao.deletePatient(selectedPatientId);
            loadPatients();
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error deleting patient: " + ex.getMessage());
        }
    }

    private void clearFields() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtDOB.setText("");
        txtGender.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        txtAdmissionDate.setText("");
        selectedPatientId = -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HospitalManagementGUI().setVisible(true));
    }
}

