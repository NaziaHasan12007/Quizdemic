package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SetPasswordPage extends BaseFrame {
    public SetPasswordPage() {
        super("Set Username and Password");

        JLabel userLabel = new JLabel("New Username:");
        JTextField usernameField = new JTextField(20);

        JLabel passLabel = new JLabel("New Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton saveButton = createButton("Save Credentials");
        
        saveButton.addActionListener((ActionEvent e) -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fields cannot be empty.");
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("./users.txt", true))) {
                writer.write(user + ":" + pass);
                writer.newLine();
                JOptionPane.showMessageDialog(this, "User added successfully.");
                new LoginPage().setVisible(true);
                dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error writing user data.");
            }
        });

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0; gbc.gridy = 0; mainPanel.add(userLabel, gbc);
        gbc.gridx = 1; mainPanel.add(usernameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; mainPanel.add(passLabel, gbc);
        gbc.gridx = 1; mainPanel.add(passwordField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        mainPanel.add(saveButton, gbc);
    }
}
