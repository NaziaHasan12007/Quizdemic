package ui;

import model.Student;
import util.PageMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenuPage extends BaseFrame {

    private final Student currentUser;

    public MainMenuPage(Student user) {
        super("Select Your Desired Operation");
        this.currentUser = user;

        JButton quizButton = createButton("Attend a Quiz");
        JButton visualizerButton = createButton("Visualize Data");
        backButton = createButton("Back");
        quizButton.addActionListener((ActionEvent e) -> {
            new QuizSubjectPage(PageMode.QUIZ_MODE, currentUser).setVisible(true);
            dispose();
        });

        visualizerButton.addActionListener((ActionEvent e) -> {
            new VisualizationPage(currentUser).setVisible(true);
            dispose();
        });

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(quizButton, gbc);
        gbc.gridy = 1;
        mainPanel.add(visualizerButton, gbc);
        addBackButtonAsLast(gbc);
        
        backButton.addActionListener(e -> {
            new LoginPage().setVisible(true);
            dispose();
        });

       
    }
}
