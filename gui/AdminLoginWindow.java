package taskmanagement.gui;

import javax.swing.*;
import java.awt.*;
import taskmanagement.MongoDBHelper;
// import taskmanagement.main_frame;

public class AdminLoginWindow extends JFrame {
    public AdminLoginWindow() {
        setTitle("Admin Login");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Name:"));
        JTextField txtAdminId = new JTextField();
        add(txtAdminId);

        add(new JLabel("Password:"));
        JPasswordField txtPassword = new JPasswordField();
        add(txtPassword);

        JButton btnLogin = new JButton("Login");
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String name = txtAdminId.getText();
            String password = new String(txtPassword.getPassword());

            // Authenticate admin credentials from the database
            boolean isAuthenticated = MongoDBHelper.authenticateAdmin(name, password);

            if (isAuthenticated) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Proceed to admin panel
                AdminPanelWindow adminPanel = new AdminPanelWindow(); // Corrected line to instantiate AdminPanelWindow
                adminPanel.setVisible(true); // Make the admin panel visible
                dispose(); // Close the login window
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        });

        setVisible(true);
    }
     public static void main(String[] args) {
        new AdminLoginWindow();
    }
}
