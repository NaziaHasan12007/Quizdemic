package ui;

import model.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminPass extends BaseFrame {

    public AdminPass() {
        super("Admin Login");

        JLabel nameLabel = new JLabel("Admin Name:");
        JTextField nameField = new JTextField(20);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        backButton= new JButton("Back");

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(passLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(loginButton, gbc);

        addBackButtonAsLast(gbc);
        
        backButton.addActionListener(e -> {
            new UserChoice().setVisible(true);
            dispose();
        });

        loginButton.addActionListener((ActionEvent e) -> {
            String username = nameField.getText().trim();
            String password = new String(passField.getPassword()).trim();

            if (Admin.isValidAdmin(username, password)) {
                JOptionPane.showMessageDialog(this, "Admin Access Granted!");
                new AdminEditor().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid admin credentials.");
            }
        });
    }
}
