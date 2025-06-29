package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WelcomePage extends JFrame {

    public WelcomePage() {
        setTitle("Welcome to Quizdemic");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = createGradientPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 300));

        try {
            ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
            setIconImage(image.getImage());
        } catch (Exception e) {
            System.out.println("Logo not found");
        }

        JButton nextButton = createWelcomeButton();
        panel.add(nextButton);

        JLabel versionLabel = new JLabel("Quizdemic v1.0");
        versionLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        versionLabel.setForeground(Color.DARK_GRAY);
        panel.add(versionLabel);

        setContentPane(panel);
    }

    private JButton createWelcomeButton() {
        JButton button = new JButton("WELCOME");
        button.setFont(new Font("Segoe UI", Font.BOLD, 24));
        button.setPreferredSize(new Dimension(300, 150));
        button.setBackground(new Color(255, 140, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

        button.addActionListener((ActionEvent a) -> {
            new LoginPage().setVisible(true);
            dispose();
        });
        return button;
    }

    private JPanel createGradientPanel() {
        return new JPanel() {
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
        };
    }
}
