package ui;

import model.Student;

import javax.swing.*;
import java.awt.*;

public class ChartDisplayPage extends BaseFrame {

    
    public ChartDisplayPage(String subject, String chartType, Student user) {
        super("Visualizing: " + chartType);

    
        JLabel label = new JLabel("Showing " + chartType + " chart for subject: " + subject);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(Color.WHITE);

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(label, gbc);
        
      
        

        
    }
}
