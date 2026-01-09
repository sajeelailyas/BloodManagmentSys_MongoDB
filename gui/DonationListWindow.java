package taskmanagement.gui;

import taskmanagement.MongoDBHelper;

import javax.swing.*;
import java.awt.*;

public class DonationListWindow extends JFrame {

    public DonationListWindow() {
        setTitle("All Donations");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        String allDonationsInfo = MongoDBHelper.getAllDonations(); // Retrieve all donations from the database
        textArea.setText(allDonationsInfo);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
