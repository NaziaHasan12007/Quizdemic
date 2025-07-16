

package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import util.PageMode;

public class MainMenuPage extends BaseFrame {

    private final String currentUsername;

    public MainMenuPage(String username) {
        super("Select Your Desired Operation");
        this.currentUsername = username;

        JButton quizButton = new JButton("Attend a Quiz");
        quizButton.setPreferredSize(new Dimension(150, 40));
        JButton visualizerButton = new JButton("Visualize Data");
        visualizerButton.setPreferredSize(new Dimension(150, 40));

        quizButton.addActionListener((ActionEvent e) -> {
            new QuizSubjectPage(PageMode.QUIZ_MODE).setVisible(true);
            dispose();
        });

        visualizerButton.addActionListener((ActionEvent e) -> {
            new VisualizationPage(currentUsername).setVisible(true);
            dispose();
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;

        gbc.gridy = 0;
        mainPanel.add(quizButton, gbc);

        gbc.gridy = 1;
        mainPanel.add(visualizerButton, gbc);
    }
}
