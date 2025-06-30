package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class QuizSubjectPage extends BaseFrame{
    QuizSubjectPage(){
        super("Select Subject");
        
        JButton subject_c = createButton("C");
        JButton subject_java = createButton("Java");
        JButton subject_dsa = createButton("DSA");

        subject_c.addActionListener((ActionEvent e) ->{
            new QuestionTypePage().setVisible(true);
            dispose();
        });
        subject_java.addActionListener((ActionEvent e) ->{
            new QuestionTypePage().setVisible(true);
            dispose();
        });
        subject_dsa.addActionListener((ActionEvent e) ->{
            new QuestionTypePage().setVisible(true);
            dispose();
        });
        
        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0; 
        gbc.gridy = 0;
        mainPanel.add(subject_c);

        gbc.gridy = 1; 
        mainPanel.add(subject_java);

        gbc.gridy = 2;
        mainPanel.add(subject_dsa);
        
    }
}

