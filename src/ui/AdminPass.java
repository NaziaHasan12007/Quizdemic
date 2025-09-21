
package ui;

import model.Admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminPass extends BaseFrame{
    private JButton loginButton;

    public AdminPass(){
        super("Admin Login");

        JLabel nameLabel=new JLabel("Admin Name:");
        nameLabel.setFont(new Font("Segoe UI",Font.BOLD,35));
        JTextField nameField=new JTextField(20);
        nameField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nameField.setPreferredSize(new Dimension(400,50));

        JLabel passLabel=new JLabel("Password:");
        passLabel.setFont(new Font("Segoe UI",Font.BOLD,35));
        JPasswordField passField=new JPasswordField(20);
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        passField.setPreferredSize(new Dimension(400,50));

        loginButton=createButton("Login");

        GridBagConstraints gbc=defaultConstraints();

        gbc.gridx=0;
        gbc.gridy=0;
        mainPanel.add(nameLabel,gbc);
        gbc.gridx=1;
        mainPanel.add(nameField,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        mainPanel.add(passLabel,gbc);
        gbc.gridx=1;
        mainPanel.add(passField,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;
        mainPanel.add(loginButton,gbc);

        addBackButtonAsLast(gbc);

        backButton.addActionListener(e->{
            new UserChoice().setVisible(true);
            dispose();
        });

        loginButton.addActionListener((ActionEvent e)->{
            String username=nameField.getText().trim();
            String password=new String(passField.getPassword()).trim();

            if(Admin.isValidAdmin(username,password)){
                JOptionPane.showMessageDialog(this,"Admin Access Granted!");
                new AdminEditor().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Invalid admin credentials.");
            }
        });
    }
}
