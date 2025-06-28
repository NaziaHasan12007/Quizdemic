package app;

import ui.WelcomePage;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new WelcomePage().setVisible(true);
        });
    }
}

