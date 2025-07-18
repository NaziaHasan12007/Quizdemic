package ui;

import javax.swing.*;
//import java.awt.*;

public class SplashScreen extends JFrame {

    public SplashScreen() {
        setUndecorated(true);

        try {
            ImageIcon logo = new ImageIcon(getClass().getResource("/ui/logo.png"));
            JLabel label = new JLabel(logo);
            add(label);
            pack();  // Resize window to fit image exactly
            setLocationRelativeTo(null);  // Center on screen
        } catch (Exception e) {
            System.out.println("Logo not found");
            setSize(400, 400);
            setLocationRelativeTo(null);
        }
    }

    public void showSplash() {
        setVisible(true);

        new Thread(() -> {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ignored) {}

            SwingUtilities.invokeLater(() -> {
                new WelcomePage().setVisible(true);
                dispose();
            });
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SplashScreen splash = new SplashScreen();
            splash.showSplash();
        });
    }
}
