package ui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public abstract class BaseFrame extends JFrame{
    protected JPanel mainPanel;
    protected JButton backButton;

    public BaseFrame(String title) {
        setTitle(title);
        setSize(1200, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        mainPanel = new GradientPanel();
        mainPanel.setLayout(new GridBagLayout());
        setContentPane(mainPanel);
    }
    
    protected JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(300, 100));
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setBackground(new Color(60, 179, 113));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        return button;
    }

    protected GridBagConstraints defaultConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }

    protected void addBackButtonAsLast(GridBagConstraints gbc) {
    if (mainPanel.getComponentCount() > 0) {
        Component comp = mainPanel.getComponent(mainPanel.getComponentCount() - 1);
        if (comp != null) {
            GridBagConstraints lastConstraints = ((GridBagLayout) mainPanel.getLayout()).getConstraints(comp);
            GridBagConstraints backConstraints = (GridBagConstraints) lastConstraints.clone();
            backConstraints.gridy += 1;
            backConstraints.gridx = 0;
            backConstraints.anchor = GridBagConstraints.WEST;
            mainPanel.add(backButton, backConstraints);
        } else {
            // fallback if somehow component is null
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            mainPanel.add(backButton, gbc);
        }
    } else {
        // if panel is empty
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(backButton, gbc);
    }
}

    static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            Color color1 = new Color(255, 204, 153);
            Color color2 = new Color(255, 94, 98);
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
    
}


