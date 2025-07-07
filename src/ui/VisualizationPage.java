package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import util.PageMode;

public class VisualizationPage extends BaseFrame {
    public VisualizationPage() {
        super("Select a type for visualization");

        JButton individualButton = createButton("Individual");
        JButton subjectButton = createButton("Subject");

        individualButton.addActionListener((ActionEvent e) -> {
            new ChartTypePage("All Subjects").setVisible(true); // Or another logic
            dispose();
        });

        subjectButton.addActionListener((ActionEvent e) -> {
            new QuizSubjectPage(PageMode.VISUALIZATION_MODE).setVisible(true);
            dispose();
        });

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(individualButton, gbc);
        gbc.gridy = 1;
        mainPanel.add(subjectButton, gbc);
    }
}
