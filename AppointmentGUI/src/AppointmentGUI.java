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
import java.util.List;

public class AppointmentGUI extends JFrame {
    private JTextField txtPatientId, txtDoctorId, txtDate, txtDescription;
    private JTable table;
    private DefaultTableModel model;
    private int selectedAppointmentId = -1;

    public AppointmentGUI() {
        setTitle("Appointments Manager");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel for input fields
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Appointment Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Fields
        txtPatientId = new JTextField(15);
        txtDoctorId = new JTextField(15);
        txtDate = new JTextField(15);
        txtDescription = new JTextField(15);

        // Row 1: Patient ID
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Patient ID:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtPatientId, gbc);

        // Row 2: Doctor ID
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Doctor ID:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtDoctorId, gbc);

        // Row 3: Date
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Appointment Date (yyyy-mm-dd):"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtDate, gbc);

        // Row 4: Description
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtDescription, gbc);

        // Row 5: Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        JButton btnAdd = new JButton("Schedule");
        JButton btnUpdate = new JButton("Update");
        JButton btnCancel = new JButton("Cancel");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnCancel);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(buttonPanel, gbc);

        // Table
        model = new DefaultTableModel(new String[]{"ID", "PatientID", "DoctorID", "Date", "Description"}, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        add(formPanel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        loadAppointments();

        // Event Listeners
        btnAdd.addActionListener(e -> addAppointment());
        btnUpdate.addActionListener(e -> updateAppointment());
        btnCancel.addActionListener(e -> cancelAppointment());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                selectedAppointmentId = Integer.parseInt(model.getValueAt(row, 0).toString());
                txtPatientId.setText(model.getValueAt(row, 1).toString());
                txtDoctorId.setText(model.getValueAt(row, 2).toString());
                txtDate.setText(model.getValueAt(row, 3).toString());
                txtDescription.setText(model.getValueAt(row, 4).toString());
            }
        });
    }

    private void loadAppointments() {
        try {
            model.setRowCount(0);
            AppointmentDAO dao = new AppointmentDAO();
            List<String[]> list = dao.getAllAppointments();
            for (String[] row : list) {
                model.addRow(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading appointments: " + ex.getMessage());
        }
    }

    private void addAppointment() {
        try {
            int patientId = Integer.parseInt(txtPatientId.getText());
            int doctorId = Integer.parseInt(txtDoctorId.getText());
            LocalDate date = LocalDate.parse(txtDate.getText());
            String desc = txtDescription.getText();

            AppointmentDAO dao = new AppointmentDAO();
            dao.insertAppointment(patientId, doctorId, date, desc);
            loadAppointments();
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error scheduling appointment: " + ex.getMessage());
        }
    }

    private void updateAppointment() {
        if (selectedAppointmentId == -1) {
            JOptionPane.showMessageDialog(this, "Select an appointment to update.");
            return;
        }
        try {
            LocalDate date = LocalDate.parse(txtDate.getText());
            String desc = txtDescription.getText();

            AppointmentDAO dao = new AppointmentDAO();
            dao.updateAppointment(selectedAppointmentId, date, desc);
            loadAppointments();
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating appointment: " + ex.getMessage());
        }
    }

    private void cancelAppointment() {
        if (selectedAppointmentId == -1) {
            JOptionPane.showMessageDialog(this, "Select an appointment to cancel.");
            return;
        }
        try {
            AppointmentDAO dao = new AppointmentDAO();
            dao.deleteAppointment(selectedAppointmentId);
            loadAppointments();
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error cancelling appointment: " + ex.getMessage());
        }
    }

    private void clearFields() {
        txtPatientId.setText("");
        txtDoctorId.setText("");
        txtDate.setText("");
        txtDescription.setText("");
        selectedAppointmentId = -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppointmentGUI().setVisible(true));
    }
}
