package ui;

import model.Student;
import util.PageMode;

import javax.swing.*;
import java.awt.*;

public class QuizSubjectPage extends BaseFrame {
    private final PageMode mode;
    private final Student currentUser;

    public QuizSubjectPage(PageMode mode, Student student) {
        super("Select Subject");
        this.mode = mode;
        this.currentUser = student;
     
        JButton subject_c = createButton("C");
        JButton subject_java = createButton("Java");
        JButton subject_dsa = createButton("DSA");
        backButton = createButton("Back");
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
         addBackButtonAsLast(gbc);
        backButton.addActionListener(e -> {
            new MainMenuPage(currentUser).setVisible(true);
            dispose();
        });

       
    }

    private void handleSubject(String subject) {
        if (mode == PageMode.QUIZ_MODE) {
            new QuestionTypePage(subject, currentUser).setVisible(true);
        } else {
            new ChartTypePage(subject, currentUser).setVisible(true);
        }
        dispose();
    }
}
