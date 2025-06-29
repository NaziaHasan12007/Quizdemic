
package ui;

import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame {

    public WelcomePage() {
        setTitle("Welcome to Quizdemic");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Use custom panel with gradient background
        GradientPanel panel = new GradientPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 300));

        // Optional: Add logo icon
        try {
            ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
            setIconImage(image.getImage());
        } catch (Exception e) {
            System.out.println("Logo not found");
        }

        // Create a styled welcome button
        JButton nextButton = new JButton("WELCOME");
        nextButton.setFont(new Font("Segoe UI", Font.BOLD, 24));
        nextButton.setPreferredSize(new Dimension(300, 150));
        nextButton.setBackground(new Color(255, 140, 0));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setOpaque(true);
        nextButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

        panel.add(nextButton);
        setContentPane(panel);
    }

    // 🌈 Inner class to paint a gradient background
    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            Color color1 = new Color(255, 204, 153); // peach
            Color color2 = new Color(255, 94, 98);   // coral-pink
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
