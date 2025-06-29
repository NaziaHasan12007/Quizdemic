package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SetPasswordPage extends JFrame {
    public SetPasswordPage() {
        setTitle("Set Your Password");
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

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        submitButton.setBackground(new Color(255, 140, 0));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

        submitButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username and password cannot be empty.");
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
                writer.write(username + ":" + password);
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Password set for user: " + username);
                dispose();
                new LoginPage().setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving credentials.");
            }
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
        gbc.gridwidth = 2;
        panel.add(submitButton, gbc);

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
