package ui;

import javax.swing.*;

public class ChartDisplayPage extends BaseFrame {
    public ChartDisplayPage(String subject, String chartType) {
        super("Visualizing: " + chartType);

        // TODO: Implement drawing logic here
        JLabel label = new JLabel("Showing " + chartType + " chart for subject: " + subject);
        mainPanel.add(label);
    }
}

