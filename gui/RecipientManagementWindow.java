package taskmanagement.gui;

import taskmanagement.MongoDBHelper;

import javax.swing.*;
import java.awt.*;

public class RecipientManagementWindow extends JFrame {

    public RecipientManagementWindow() {
        setTitle("Recipient Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        // Add components for recipient tasks
        JButton btnAddRecipient = new JButton("Add Recipient");
        JButton btnViewAllRecipients = new JButton("View All Recipients");

        // Add action listeners for recipient tasks
        btnAddRecipient.addActionListener(e -> {
            // Add recipient logic here
            String name = JOptionPane.showInputDialog(this, "Enter recipient name:");
            String bloodType = JOptionPane.showInputDialog(this, "Enter recipient blood type:");
            String city = JOptionPane.showInputDialog(this, "Enter recipient city:");
            if (name != null && !name.isEmpty() && bloodType != null && !bloodType.isEmpty() && city != null && !city.isEmpty()) {
                MongoDBHelper.addRecipient(name, bloodType, city);
                JOptionPane.showMessageDialog(this, "Recipient added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Recipient name, blood type, or city cannot be empty.");
            }
        });

        btnViewAllRecipients.addActionListener(e -> {
            // View all recipients logic here
            String allRecipients = MongoDBHelper.getAllRecipients();
            new AllRecipientsWindow(allRecipients);
        });

        // Add buttons to the window
        add(btnAddRecipient);
        add(btnViewAllRecipients);

        // Set the window visibility
        setVisible(true);
    }
}
