package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import util.PageMode;

public class QuizSubjectPage extends BaseFrame {
    private PageMode mode;

    public QuizSubjectPage(PageMode mode) {
        super("Select Subject");
        this.mode = mode;

        JButton subject_c = createButton("C");
        JButton subject_java = createButton("Java");
        JButton subject_dsa = createButton("DSA");

        subject_c.addActionListener(e -> handleSubject("C"));
        subject_java.addActionListener(e -> handleSubject("Java"));
        subject_dsa.addActionListener(e -> handleSubject("DSA"));

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;

        gbc.gridy = 0;
        mainPanel.add(subject_c, gbc);
        gbc.gridy = 1;
        mainPanel.add(subject_java, gbc);
        gbc.gridy = 2;
        mainPanel.add(subject_dsa, gbc);
    }

    private void handleSubject(String subject) {
        if (mode == PageMode.QUIZ_MODE) {
            new QuestionTypePage(subject).setVisible(true);
        } else {
            new ChartTypePage(subject).setVisible(true);
        }
        dispose();
    }
}
