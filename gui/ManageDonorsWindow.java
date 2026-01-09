package taskmanagement.gui;

import taskmanagement.MongoDBHelper;
import taskmanagement.model.donor;

import javax.swing.*;
import java.awt.*;

public class ManageDonorsWindow extends JFrame {

    public ManageDonorsWindow() {
        setTitle("Manage Donors");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JButton btnAddDonor = new JButton("Add Donor");
        JButton btnDeleteDonor = new JButton("Delete Donor");
        JButton btnUpdateDonor = new JButton("Update Donor");
        JButton btnViewAllDonors = new JButton("View All Donors");

        btnAddDonor.addActionListener(e -> {
            AddDonorWindow donorWindow = new AddDonorWindow();
            donorWindow.setVisible(true);
            dispose();
            
        });

        btnDeleteDonor.addActionListener(e -> {
            String donorID = JOptionPane.showInputDialog(this, "Enter donor ID to delete:");
            if (donorID != null && !donorID.isEmpty()) {
                boolean isDeleted = MongoDBHelper.deleteDonor(donorID);
                if (isDeleted) {
                    JOptionPane.showMessageDialog(this, "Donor deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Donor not found or could not be deleted.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Donor ID cannot be empty.");
            }
        });

        btnUpdateDonor.addActionListener(e -> {
            String donorID = JOptionPane.showInputDialog(this, "Enter donor ID to update:");
            if (donorID != null && !donorID.isEmpty()) {
                donor existingDonor = MongoDBHelper.getDonorById(donorID);
        
                if (existingDonor != null) {
                    JTextField txtName = new JTextField(existingDonor.getName());
                    JTextField txtCnic = new JTextField(existingDonor.getCnic());
                    JTextField txtAge = new JTextField(String.valueOf(existingDonor.getAge()));
                    JTextField txtGender = new JTextField(existingDonor.getGender());
                    JTextField txtContactNo = new JTextField(existingDonor.getContactNo());
                    JTextField txtBloodType = new JTextField(existingDonor.getBloodType());
                    
                    // Check if quantity is null, assign default value if necessary
                    Integer quantity = existingDonor.getQuantity();
                    
                    JTextField txtQuantity = new JTextField(String.valueOf(quantity));
                    
                    JTextField txtCity = new JTextField(existingDonor.getCity());
        
                    JPanel panel = new JPanel(new GridLayout(8, 2));
                    panel.add(new JLabel("Name:"));
                    panel.add(txtName);
                    panel.add(new JLabel("CNIC:"));
                    panel.add(txtCnic);
                    panel.add(new JLabel("Age:"));
                    panel.add(txtAge);
                    panel.add(new JLabel("Gender:"));
                    panel.add(txtGender);
                    panel.add(new JLabel("Contact No:"));
                    panel.add(txtContactNo);
                    panel.add(new JLabel("Blood Type:"));
                    panel.add(txtBloodType);
                    panel.add(new JLabel("Donation Quantity:"));
                    panel.add(txtQuantity);
                    panel.add(new JLabel("City:"));
                    panel.add(txtCity);
        
                    int result = JOptionPane.showConfirmDialog(this, panel, "Update Donor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (result == JOptionPane.OK_OPTION) {
                        existingDonor.setName(txtName.getText());
                        existingDonor.setCnic(txtCnic.getText());
                        existingDonor.setAge(Integer.parseInt(txtAge.getText()));
                        existingDonor.setGender(txtGender.getText());
                        existingDonor.setContactNo(txtContactNo.getText());
                        existingDonor.setBloodType(txtBloodType.getText());
                        existingDonor.setQuantity(Integer.parseInt(txtQuantity.getText()));
                        existingDonor.setCity(txtCity.getText());
        
                        MongoDBHelper.updateDonor(donorID, existingDonor);
                        MongoDBHelper.addDonation(donorID, existingDonor.getName(), existingDonor.getQuantity());
                        JOptionPane.showMessageDialog(this, "Donor updated successfully!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Donor not found.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Donor ID cannot be empty.");
            }
        });
        
        

        btnViewAllDonors.addActionListener(e -> {
            new DonorListWindow();
            dispose();
        });
        

        add(btnAddDonor);
        add(btnDeleteDonor);
        add(btnUpdateDonor);
        add(btnViewAllDonors);

        setVisible(true);
    }
}
