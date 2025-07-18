package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WelcomePage extends BaseFrame {

    public WelcomePage() {
        super("Welcome to Quizdemic");

        try {
            ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
            setIconImage(image.getImage());
        } catch (Exception e) {
            System.out.println("Logo not found");
        }

        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 300));

        JButton nextButton = createButton("Welcome");
        mainPanel.add(nextButton);
        nextButton.addActionListener((ActionEvent e) ->{
           new LoginPage().setVisible(true);
           dispose();
        });

        setContentPane(mainPanel);
    }
}