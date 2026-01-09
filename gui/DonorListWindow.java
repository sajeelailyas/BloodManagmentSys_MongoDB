package taskmanagement.gui;

import taskmanagement.MongoDBHelper;

import javax.swing.*;
import java.awt.*;


public class DonorListWindow extends JFrame {

    public DonorListWindow() {
        setTitle("All Donors");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        String allDonorsInfo = MongoDBHelper.getAllDonors1(); // Retrieve all donors from the database
        textArea.setText(allDonorsInfo);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
