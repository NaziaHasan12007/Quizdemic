package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenuPage extends BaseFrame {
    public MainMenuPage() {
        super("Select Your Desired Operation");

        JButton quizButton = createButton("Attend a Quiz");
        JButton visualizerButton = createButton("Visualize Data");

        quizButton.addActionListener((ActionEvent e) -> {
            new QuizSubjectPage().setVisible(true);
            dispose();
        });

        visualizerButton.addActionListener((ActionEvent e) -> {
            // new VisualizationPage().setVisible(true);
            dispose();
        });

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0; gbc.gridy = 0; mainPanel.add(quizButton, gbc);
        gbc.gridy = 1; mainPanel.add(visualizerButton, gbc);
    }

}
