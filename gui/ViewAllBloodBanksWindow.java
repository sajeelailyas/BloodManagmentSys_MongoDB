package taskmanagement.gui;

import taskmanagement.MongoDBHelper;

import javax.swing.*;
import java.awt.*;

public class ViewAllBloodBanksWindow extends JFrame {

    public ViewAllBloodBanksWindow() {
        setTitle("All Blood Banks");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setText(MongoDBHelper.getAllBloodBanks());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
