package ui;

import model.Student;
import util.UserSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class LoginPage extends BaseFrame {

    public LoginPage() {
        super("Login with Credentials");
        backButton = createButton("Back");
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        JTextField usernameField = new JTextField(20);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = createButton("Login");
        JButton setPasswordButton = createButton("Set Password");

        loginButton.addActionListener((ActionEvent e) -> {
            String inputUser = usernameField.getText();
            String inputPass = new String(passwordField.getPassword());
            boolean found = false;

            try (BufferedReader reader = new BufferedReader(new FileReader("./users.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2 && parts[0].equals(inputUser) && parts[1].equals(inputPass)) {
                        found = true;
                        break;
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading user data.");
            }

            if (found) {
                Student student = new Student(inputUser, inputPass);
                UserSession.setCurrentUser(student);
                new MainMenuPage(student).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        });

        setPasswordButton.addActionListener((ActionEvent e) -> {
            new SetPasswordPage().setVisible(true);
            dispose();
        });

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        mainPanel.add(userLabel, gbc);
        gbc.gridx = 1; 
        mainPanel.add(usernameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; 
        mainPanel.add(passLabel, gbc);
        gbc.gridx = 1; mainPanel.add(passwordField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; 
        mainPanel.add(loginButton, gbc);
        gbc.gridy = 3;
        mainPanel.add(setPasswordButton, gbc);

        addBackButtonAsLast(gbc);

        backButton.addActionListener(e -> {
            new WelcomePage().setVisible(true);
            dispose();
        });
        
    }
}
