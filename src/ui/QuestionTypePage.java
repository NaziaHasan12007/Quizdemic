package ui;

import model.Question;
import model.QuizSession;
import io.QuestionLoader;
import util.UserSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.List;

public class QuestionTypePage extends BaseFrame {
    private String subject;

    public QuestionTypePage(String subject) {
        super("Select question type");
        this.subject = subject;

        JButton mcqButton = createButton("MCQ");
        JButton TFButton = createButton("True-False");

        mcqButton.addActionListener((ActionEvent e) -> {
            String path = "src/data/question/" + subject.toLowerCase() + "/mcq.json";
            try {
                List<Question> questions = QuestionLoader.loadQuestions(path, "MCQ");
                Collections.shuffle(questions);
                questions = questions.subList(0, Math.min(30, questions.size()));
                QuizSession session = new QuizSession(UserSession.getCurrentUsername(), subject, "MCQ", questions);
                new QuizPage(session).setVisible(true);
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to load MCQ questions.");
            }
        });

        TFButton.addActionListener((ActionEvent e) -> {
            String path = "src/data/question/" + subject.toLowerCase() + "/tf.json";
            try {
                List<Question> questions = QuestionLoader.loadQuestions(path, "TrueFalse");
                Collections.shuffle(questions);
                questions = questions.subList(0, Math.min(30, questions.size()));
                QuizSession session = new QuizSession(UserSession.getCurrentUsername(), subject, "TrueFalse", questions);
                new QuizPage(session).setVisible(true);
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to load True/False questions.");
            }
        });

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(mcqButton, gbc);
        gbc.gridy = 1;
        mainPanel.add(TFButton, gbc);
    }
}
