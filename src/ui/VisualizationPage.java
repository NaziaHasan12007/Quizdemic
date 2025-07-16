
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VisualizationPage extends BaseFrame {
    private final String username;

    public VisualizationPage(String username) {
        super("Select a type for visualization");
        this.username = username;

        JButton individualButton = new JButton("Individual");
        individualButton.setPreferredSize(new Dimension(150, 40));

        JButton subjectButton = new JButton("Subject");
        subjectButton.setPreferredSize(new Dimension(150, 40));

        individualButton.addActionListener((ActionEvent e) -> {
            visualizer.ResultVisualizer.showPieChart(username);
        });

        subjectButton.addActionListener((ActionEvent e) -> {
            visualizer.ResultVisualizer.showBarChart(username);
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;

        gbc.gridy = 0;
        mainPanel.add(individualButton, gbc);

        gbc.gridy = 1;
        mainPanel.add(subjectButton, gbc);

        setVisible(true);
    }
}
