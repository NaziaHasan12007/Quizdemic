package ui;

import model.Question;
import model.QuizSession;
import model.Student;
import io.QuestionLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuestionTypePage extends BaseFrame {
    private final String subject;
    private final Student currentUser;
    
    public QuestionTypePage(String subject, Student user) {
        super("Select Question Type");
        this.subject = subject;
        this.currentUser = user;

        JButton mcqButton = createButton("MCQ");
        JButton tfButton = createButton("True-False");
        backButton = createButton("Back");
        mcqButton.addActionListener(e -> loadAndStartQuiz("mcq"));
        tfButton.addActionListener(e -> loadAndStartQuiz("truefalse"));

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(mcqButton, gbc);
        gbc.gridy = 1;
        mainPanel.add(tfButton, gbc);

        addBackButtonAsLast(gbc);
        backButton.addActionListener(e -> {
            new QuizSubjectPage(util.PageMode.QUIZ_MODE, currentUser).setVisible(true);
            dispose();
        });
    }

    private void loadAndStartQuiz(String type) {
        try {
            List<Question> questions = QuestionLoader.loadQuestions(subject, type);
            QuizSession session = new QuizSession(currentUser.getUsername(), subject, type, questions);
            new QuizPage(session).setVisible(true);
            dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load " + type + " questions.");
        }
    }
}
