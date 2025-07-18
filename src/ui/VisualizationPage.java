package ui;

import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VisualizationPage extends BaseFrame {
    private final Student currentUser;

    public VisualizationPage(Student user) {
        super("Select a type for visualization");
        this.currentUser = user;

        JButton individualButton = createButton("Individual");
        JButton subjectButton = createButton("Subject");
        backButton= createButton("Back");
        individualButton.addActionListener((ActionEvent e) -> {
            visualizer.ResultVisualizer.showPieChart(currentUser.getUsername());
        });

        subjectButton.addActionListener((ActionEvent e) -> {
            visualizer.ResultVisualizer.showBarChart(currentUser.getUsername());
        });

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(individualButton, gbc);
        gbc.gridy = 1;
        mainPanel.add(subjectButton, gbc);
         addBackButtonAsLast(gbc);
        backButton.addActionListener(e -> {
            new MainMenuPage(currentUser).setVisible(true);
            dispose();
        });
       
    }
}
