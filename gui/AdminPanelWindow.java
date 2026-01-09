package taskmanagement.gui;

import taskmanagement.MongoDBHelper;

import javax.swing.*;
import java.awt.*;

public class AdminPanelWindow extends JFrame {

    public AdminPanelWindow() {
        setTitle("Admin Panel");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1)); // Change the grid layout to 8 rows

        // Add components for admin tasks (e.g., add admin, delete admin, view all admins)
        JButton btnAddAdmin = new JButton("Add Admin");
        JButton btnDeleteAdmin = new JButton("Delete Admin");
        JButton btnViewAllAdmins = new JButton("View All Admins");
        JButton btnManageDonors = new JButton("Manage Donors");
        JButton btnViewAllDonations = new JButton("View All Donations");
        JButton btnManageBloodBanks = new JButton("Manage Blood Banks");
        JButton btnManageBloodTransfusions = new JButton("Manage Blood Transfusions");
        JButton btnManageRecipients = new JButton("Manage Recipients"); // New button

        // Add action listeners for admin tasks
        btnAddAdmin.addActionListener(e -> {
            // Add admin logic here
            String name = JOptionPane.showInputDialog(this, "Enter admin name:");
            String password = JOptionPane.showInputDialog(this, "Enter admin password:");
            if (name != null && !name.isEmpty() && password != null && !password.isEmpty()) {
                MongoDBHelper.addAdmin(name, password);
                JOptionPane.showMessageDialog(this, "Admin added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Admin name or password cannot be empty.");
            }
        });

        btnDeleteAdmin.addActionListener(e -> {
            // Delete admin logic here
            String adminID = JOptionPane.showInputDialog(this, "Enter admin ID to delete:");
            if (adminID != null && !adminID.isEmpty()) {
                boolean isDeleted = MongoDBHelper.deleteAdmin(adminID);
                if (isDeleted) {
                    JOptionPane.showMessageDialog(this, "Admin deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Admin not found or could not be deleted.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Admin ID cannot be empty.");
            }
        });

        btnViewAllAdmins.addActionListener(e -> {
            // View all admins logic here
            String allAdmins = MongoDBHelper.getAllAdmins();
            JOptionPane.showMessageDialog(this, allAdmins, "All Admins", JOptionPane.INFORMATION_MESSAGE);
        });

        btnManageDonors.addActionListener(e -> {
            // Manage donors logic here
            new ManageDonorsWindow(); // Open the ManageDonorsWindow
        });

        btnViewAllDonations.addActionListener(e -> {
            // View all donations logic here
            new DonationListWindow(); // Open the DonationListWindow
            
        });

        btnManageBloodBanks.addActionListener(e -> {
            new BloodBankManagementWindow(); // Open the BloodBankManagementWindow
        });

        btnManageBloodTransfusions.addActionListener(e -> {
            // Manage blood transfusions logic here
            new BloodTransfusionManagementWindow(); // Open the BloodTransfusionManagementWindow
        });

        btnManageRecipients.addActionListener(e -> {
            // Manage recipients logic here
            new RecipientManagementWindow(); // Open the RecipientManagementWindow
        });

        // Add buttons to admin panel
        add(btnAddAdmin);
        add(btnDeleteAdmin);
        add(btnViewAllAdmins);
        add(btnManageDonors);
        add(btnViewAllDonations);
        add(btnManageBloodBanks);
        add(btnManageBloodTransfusions);
        add(btnManageRecipients); // Add the new button to the panel
    }
}
