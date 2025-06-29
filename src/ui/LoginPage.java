package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class LoginPage extends JFrame {
    public LoginPage() {
        setTitle("Log in with credentials");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        GradientPanel panel = new GradientPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        loginButton.setBackground(new Color(255, 140, 0));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

        JButton setPasswordButton = new JButton("Set Password");
        setPasswordButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        setPasswordButton.setBackground(new Color(255, 160, 122));
        setPasswordButton.setForeground(Color.WHITE);
        setPasswordButton.setFocusPainted(false);
        setPasswordButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

        // Login validation logic
        loginButton.addActionListener((ActionEvent e) -> {
            String inputUser = usernameField.getText();
            String inputPass = new String(passwordField.getPassword());
            boolean found = false;

            try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
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
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Proceed to main menu/dashboard here
                dispose(); // close login window
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        });

        setPasswordButton.addActionListener((ActionEvent e) -> {
            dispose();
            new SetPasswordPage().setVisible(true);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(loginButton, gbc);

        gbc.gridx = 1;
        panel.add(setPasswordButton, gbc);

        setContentPane(panel);
    }

    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            Color color1 = new Color(255, 204, 153);
            Color color2 = new Color(255, 94, 98);
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
