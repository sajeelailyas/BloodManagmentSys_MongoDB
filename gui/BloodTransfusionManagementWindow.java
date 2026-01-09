package taskmanagement.gui;

import taskmanagement.MongoDBHelper;

import javax.swing.*;
import java.awt.*;

public class BloodTransfusionManagementWindow extends JFrame {

    public BloodTransfusionManagementWindow() {
        setTitle("Blood Transfusion Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        // Add components for blood transfusion tasks
        JButton btnAddBloodTransfusion = new JButton("Add Blood Transfusion");
        JButton btnViewAllBloodTransfusions = new JButton("View All Blood Transfusions");

        // Add action listeners for blood transfusion tasks
        btnAddBloodTransfusion.addActionListener(e -> {
            // Add blood transfusion logic here
            String donorID = JOptionPane.showInputDialog(this, "Enter donor ID:");
            String recipientID = JOptionPane.showInputDialog(this, "Enter recipient ID:");
            String bloodBankName = JOptionPane.showInputDialog(this, "Enter blood bank name:");
            String bloodType = JOptionPane.showInputDialog(this, "Enter blood type:");
            String quantityStr = JOptionPane.showInputDialog(this, "Enter quantity:");
            String date = JOptionPane.showInputDialog(this, "Enter date of transfusion (YYYY-MM-DD):");

            if (donorID != null && !donorID.isEmpty() &&
                recipientID != null && !recipientID.isEmpty() &&
                bloodBankName != null && !bloodBankName.isEmpty() &&
                bloodType != null && !bloodType.isEmpty() &&
                quantityStr != null && !quantityStr.isEmpty() &&
                date != null && !date.isEmpty()) {

                int quantity;
                try {
                    quantity = Integer.parseInt(quantityStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid quantity.");
                    return;
                }

                if (MongoDBHelper.isDonorAvailable(donorID) &&
                    MongoDBHelper.isRecipientAvailable(recipientID) &&
                    MongoDBHelper.isBloodBankAvailable(bloodBankName)) {

                    if (MongoDBHelper.isBloodTypeAndQuantityAvailable(bloodBankName, bloodType, quantity)) {
                        MongoDBHelper.addBloodTransfusion(donorID, recipientID, bloodBankName, bloodType, quantity, date);
                        JOptionPane.showMessageDialog(this, "Blood transfusion added successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Blood quantity is less or blood type not available.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid donor ID, recipient ID, or blood bank name.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Donor ID, recipient ID, blood bank name, blood type, quantity, or date cannot be empty.");
            }
        });

        btnViewAllBloodTransfusions.addActionListener(e -> {
            // View all blood transfusions logic here
            String allBloodTransfusions = MongoDBHelper.getAllBloodTransfusions();
            JOptionPane.showMessageDialog(this, allBloodTransfusions, "All Blood Transfusions", JOptionPane.INFORMATION_MESSAGE);
        });

        // Add buttons to the window
        add(btnAddBloodTransfusion);
        add(btnViewAllBloodTransfusions);

        // Set the window visibility
        setVisible(true);
    }
}
