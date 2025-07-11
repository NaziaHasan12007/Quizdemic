package ui;

import model.QuizSession;
import model.Quizresult;

import javax.swing.*;
import java.awt.*;

public class QuizResultPage extends BaseFrame {
    
    public QuizResultPage(QuizSession session) {
        super("Result Summary");

        int total = session.getTotalQuestions();
        int correct = session.getCorrectAnswerCount();
        int wrong = session.getWrongAnswerCount();
        int skipped = total - session.getUserAnswers().size();
        double score = session.getFinalMarks();
        long time = session.getTimeTakenInSeconds();

        JLabel correctLabel = new JLabel("Correct: " + correct);
        JLabel wrongLabel = new JLabel("Wrong: " + wrong);
        JLabel skippedLabel = new JLabel("Skipped: " + skipped);
        JLabel totalLabel = new JLabel("Total Questions: " + total);
        JLabel finalMarksLabel = new JLabel("Final Marks: " + score);
        JLabel timeLabel = new JLabel("Time Taken: " + time + " seconds");

        Font f = new Font("Segoe UI", Font.BOLD, 22);
        for (JLabel label : new JLabel[]{correctLabel, wrongLabel, skippedLabel, totalLabel, finalMarksLabel, timeLabel}) {
            label.setFont(f);
            label.setForeground(Color.WHITE);
        }

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(correctLabel, gbc);
        gbc.gridy++;
        mainPanel.add(wrongLabel, gbc);
        gbc.gridy++;
        mainPanel.add(skippedLabel, gbc);
        gbc.gridy++;
        mainPanel.add(totalLabel, gbc);
        gbc.gridy++;
        mainPanel.add(finalMarksLabel, gbc);
        gbc.gridy++;
        mainPanel.add(timeLabel, gbc);

        JButton back = createButton("Back to Menu");
        back.addActionListener(e -> {
            new MainMenuPage().setVisible(true);
            dispose();
        });
        gbc.gridy++;
        mainPanel.add(back, gbc);
    }
}
