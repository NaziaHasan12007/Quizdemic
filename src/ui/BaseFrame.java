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
    
    /*protected JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(300, 100));
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setBackground(new Color(60, 179, 113));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        return button;
    }*/
    protected JButton createButton(String text) {
    JButton button = new JButton(text) {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Color startColor = new Color(255, 153, 102); // Light orange
            Color endColor = new Color(255, 94, 98);    // Pinkish red

            GradientPaint gp = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
            g2.setPaint(gp);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

            g2.dispose();
            super.paintComponent(g);
        }
    };

    button.setPreferredSize(new Dimension(300, 100));
    button.setFont(new Font("Segoe UI", Font.BOLD, 20));
    button.setForeground(Color.WHITE);
    button.setFocusPainted(false);
    button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    button.setContentAreaFilled(false); // Needed for custom painting
    button.setOpaque(false);

    // Hover effect
    button.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setForeground(new Color(255, 50, 128)); // Lighter text
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setForeground(Color.WHITE);
        }
    });

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
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            mainPanel.add(backButton, gbc);
        }
    } else {
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


