package taskmanagement.gui;

import javax.swing.*;
import java.awt.*;

public class AllRecipientsWindow extends JFrame {

    public AllRecipientsWindow(String allRecipients) {
        setTitle("All Recipients");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a text area to display the recipients
        JTextArea textArea = new JTextArea(allRecipients);
        textArea.setEditable(false); // Make the text area non-editable

        // Add the text area to a scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the scroll pane to the window
        add(scrollPane, BorderLayout.CENTER);

        // Set the window visibility
        setVisible(true);
    }
}
 