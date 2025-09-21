package ui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;

import javax.swing.JButton;



public class UserChoice extends BaseFrame{
    public UserChoice(){
       super("How do you want to enter");

       JButton studentButton = createButton("Enter as a Student");
       JButton adminButton = createButton("Enter as an Admin");
       studentButton.addActionListener((ActionEvent e) -> {
            new LoginPage().setVisible(true);
            dispose();
        });
        adminButton.addActionListener((ActionEvent e)->{
            new AdminPass().setVisible(true);
            dispose();
        });

       GridBagConstraints gbc= new GridBagConstraints();

       gbc.gridx= 0;
       gbc.gridy =0;
       mainPanel.add(studentButton, gbc);
       gbc.gridy=1;
       mainPanel.add(adminButton, gbc);


    }
}
