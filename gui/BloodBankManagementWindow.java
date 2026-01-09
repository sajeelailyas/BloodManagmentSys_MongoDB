package taskmanagement.gui;

import taskmanagement.MongoDBHelper;

import javax.swing.*;
import java.awt.*;

public class BloodBankManagementWindow extends JFrame {

    public BloodBankManagementWindow() {
        setTitle("Manage Blood Banks");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JButton btnAddBank = new JButton("Add Bank");
        JButton btnViewAllBanks = new JButton("View All Banks");

        btnAddBank.addActionListener(e -> {
            String bankName = JOptionPane.showInputDialog(this, "Enter blood bank name:");
            if (bankName != null && !bankName.isEmpty()) {
                MongoDBHelper.addBloodBank(bankName);
                JOptionPane.showMessageDialog(this, "Blood bank added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Blood bank name cannot be empty.");
            }
        });

        btnViewAllBanks.addActionListener(e -> {
            new ViewAllBloodBanksWindow();
        });

        add(btnAddBank);
        add(btnViewAllBanks);

        setVisible(true);
    }
}
