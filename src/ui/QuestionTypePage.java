package ui;

import app.Main;
import com.google.gson.Gson;
import model.Question;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
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

        loadQuestions();
    }

    public void loadQuestions() {
        try {
            Gson gson = new Gson();

            FileReader reader = new FileReader("D:\\Quizdemic\\src\\data\\question\\c\\mcq.json");

            // InputStreamReader reader = new InputStreamReader(input);
            Question[] questions = gson.fromJson(reader, Question[].class);

            for (Question q : questions) {
                System.out.println(q);
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
}
