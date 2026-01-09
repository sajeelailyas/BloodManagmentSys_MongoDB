package taskmanagement.gui;

import taskmanagement.MongoDBHelper;
import taskmanagement.model.donor;

import javax.swing.*;
import java.awt.*;

public class AddDonorWindow extends JFrame {
    private static final String[] VALID_BLOOD_TYPES = {"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};

    public AddDonorWindow() {
        setTitle("Add Donor");
        setSize(400, 400); // Increased size to accommodate larger text fields
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Setting the default properties for the GridBagConstraints
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension textFieldSize = new Dimension(200, 25); // Set preferred size for text fields

        // Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        JTextField txtName = new JTextField();
        txtName.setPreferredSize(textFieldSize);
        add(txtName, gbc);

        // CNIC
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("CNIC:"), gbc);
        gbc.gridx = 1;
        JTextField txtCnic = new JTextField();
        txtCnic.setPreferredSize(textFieldSize);
        add(txtCnic, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Age:"), gbc);
        gbc.gridx = 1;
        JTextField txtAge = new JTextField();
        txtAge.setPreferredSize(textFieldSize);
        add(txtAge, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1;
        JTextField txtGender = new JTextField();
        txtGender.setPreferredSize(textFieldSize);
        add(txtGender, gbc);

        // Contact No
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Contact No:"), gbc);
        gbc.gridx = 1;
        JTextField txtContactNo = new JTextField();
        txtContactNo.setPreferredSize(textFieldSize);
        add(txtContactNo, gbc);

        // Blood Type
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Blood Type:"), gbc);
        gbc.gridx = 1;
        JTextField txtBloodType = new JTextField();
        txtBloodType.setPreferredSize(textFieldSize);
        add(txtBloodType, gbc);

        // Quantity
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Quantity (ml):"), gbc);
        gbc.gridx = 1;
        JTextField txtQuantity = new JTextField();
        txtQuantity.setPreferredSize(textFieldSize);
        add(txtQuantity, gbc);

        // City
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("City:"), gbc);
        gbc.gridx = 1;
        JTextField txtCity = new JTextField();
        txtCity.setPreferredSize(textFieldSize);
        add(txtCity, gbc);

        // Add Donor button
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnAdd = new JButton("Add Donor");
        add(btnAdd, gbc);

        btnAdd.addActionListener(e -> {
            String name = txtName.getText();
            String cnic = txtCnic.getText();
            int age = Integer.parseInt(txtAge.getText());
            String gender = txtGender.getText();
            String contactNo = txtContactNo.getText();
            String bloodType = txtBloodType.getText().toUpperCase();
            int quantity = Integer.parseInt(txtQuantity.getText());
            String city = txtCity.getText();

            // Validate blood type
            if (!isValidBloodType(bloodType)) {
                JOptionPane.showMessageDialog(this, "Invalid blood type. Please enter a valid blood type (O+, O-, A+, A-, B+, B-, AB+, AB-).");
                return;
            }

            if (!MongoDBHelper.checkBloodBankExists(city)) {
                JOptionPane.showMessageDialog(this, "Blood bank in " + city + " is not available.");
                return;
            }

            donor donor = new donor(name, cnic, age, gender, contactNo, bloodType, quantity, city);

            String id = MongoDBHelper.addDonor_return(donor);
            MongoDBHelper.addDonation(id, name, quantity);
            MongoDBHelper.updateBloodBankQuantity(city, bloodType, quantity); // Update blood bank quantity

            JOptionPane.showMessageDialog(this, "Donor added successfully!");
        });

        setVisible(true);
    }

    private boolean isValidBloodType(String bloodType) {
        for (String validBloodType : VALID_BLOOD_TYPES) {
            if (validBloodType.equals(bloodType)) {
                return true;
            }
        }
        return false;
    }
}
