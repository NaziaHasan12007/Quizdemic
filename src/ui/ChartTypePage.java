package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChartTypePage extends BaseFrame {
    private String subject;

    public ChartTypePage(String subject) {
        super("Select the type of the chart");
        this.subject = subject;

        JButton pieButton = createButton("Pie Chart");
        JButton barButton = createButton("Bar Chart");

        pieButton.addActionListener((ActionEvent e) -> {
            new ChartDisplayPage(subject, "Pie").setVisible(true); // You define this
            dispose();
        });

        barButton.addActionListener((ActionEvent e) -> {
            new ChartDisplayPage(subject, "Bar").setVisible(true);
            dispose();
        });

        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(pieButton, gbc);
        gbc.gridy = 1;
        mainPanel.add(barButton, gbc);
    }
}
