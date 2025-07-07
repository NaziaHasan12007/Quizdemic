package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class QuestionTypePage extends BaseFrame {
    private String subject;

    public QuestionTypePage(String subject) {
        super("Select question type");
        this.subject = subject;

        JButton mcqButton = createButton("MCQ");
        JButton TFButton = createButton("True-False");

        /*mcqButton.addActionListener((ActionEvent e) -> {
            new QuizPage(subject, "MCQ").setVisible(true); // You create this
            dispose();
        });

        TFButton.addActionListener((ActionEvent e) -> {
            new QuizPage(subject, "TF").setVisible(true); // You create this
            dispose();
        });*/

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(mcqButton, gbc);
        gbc.gridy = 1;
        mainPanel.add(TFButton, gbc);
    }
}
