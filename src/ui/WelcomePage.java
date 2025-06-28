package ui;

import javax.swing.*;

public class WelcomePage extends JFrame {
    public WelcomePage() {
        setTitle("Welcome to Quizdemic");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton nextButton = new JButton("Continue");
        add(nextButton);
    }
}
