// package taskmanagement;
// import taskmanagement.gui.*;
// import javax.swing.*;
// import java.awt.*;

// public class main_frame extends JFrame {
//     public main_frame() {
//         setTitle("Blood Donation System");
//         setSize(400, 300);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new GridLayout(3, 1));

//         JButton btnAdminLogin = new JButton("Admin Login");
//         JButton btnDonorLogin = new JButton("Donor Login");
//         JButton btnDonorSignup = new JButton("Donor Signup");

//         btnAdminLogin.addActionListener(e -> new AdminLoginWindow());
//         btnDonorLogin.addActionListener(e -> new DonorLoginWindow());
//         btnDonorSignup.addActionListener(e -> new DonorSignupWindow());

//         add(btnAdminLogin);
//         add(btnDonorLogin);
//         add(btnDonorSignup);

//         setVisible(true);
//     }

//     public static void main(String[] args) {
//         new main_frame();
//     }
// }
