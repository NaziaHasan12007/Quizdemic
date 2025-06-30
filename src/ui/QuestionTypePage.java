package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class QuestionTypePage extends BaseFrame{
    QuestionTypePage(){

        super("Select question type");

        JButton mcqButton= createButton("MCQ");
        JButton TFButton = createButton("True-False");
        
        mcqButton.addActionListener((ActionEvent e) ->{
            //new QuizPage().setVisible(true);
        });
        
        TFButton.addActionListener((ActionEvent e) ->{
            //new QuizPage().setVisible(true);
        });

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        mainPanel.add(mcqButton);
        gbc.gridy=1;
        mainPanel.add(TFButton);

    }
}
