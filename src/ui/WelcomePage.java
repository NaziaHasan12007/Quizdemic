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

        getContentPane().setBackground(new Color(255, 204, 153)); // Warm peach

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 300));

        ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
        setIconImage(image.getImage());

        JButton nextButton = new JButton("Welcome");
        nextButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        nextButton.setPreferredSize(new Dimension(250, 150));    
        nextButton.setBackground(new Color(255, 229, 200));     
        nextButton.setForeground(Color.BLACK);                  
        nextButton.setFocusPainted(false);
        nextButton.setOpaque(true);
        nextButton.setBorderPainted(true);

        add(nextButton);
    }
}
