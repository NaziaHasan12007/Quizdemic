package ui;

import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChartTypePage extends BaseFrame {
    private final String subject;
    private final Student currentUser;

    public ChartTypePage(String subject, Student user) {
        super("Select the type of the chart");
        this.subject = subject;
        this.currentUser = user;
        
        JButton pieButton = createButton("Pie Chart");
        JButton barButton = createButton("Bar Chart");
        backButton = createButton("Back");
        pieButton.addActionListener((ActionEvent e) -> {
            new ChartDisplayPage(subject, "Pie", currentUser).setVisible(true);
            dispose();
        });

        barButton.addActionListener((ActionEvent e) -> {
            new ChartDisplayPage(subject, "Bar", currentUser).setVisible(true);
            dispose();
        });

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(pieButton, gbc);
        gbc.gridy = 1;
        mainPanel.add(barButton, gbc);

        addBackButtonAsLast(gbc);
        
        backButton.addActionListener(e -> {
            new QuizSubjectPage(util.PageMode.VISUALIZATION_MODE, currentUser).setVisible(true);
            dispose();
        });

        
    }
}
