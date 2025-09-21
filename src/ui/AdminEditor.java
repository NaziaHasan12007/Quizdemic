package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdminEditor extends BaseFrame {

    private JTextArea textArea;
    private JComboBox<String> subjectBox;
    private JComboBox<String> typeBox;
    private JButton loadButton, saveButton, backButton;
    private final String BASE_PATH="src/data/question/"; 

    public AdminEditor() {
        super("Admin Editor"); 

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setOpaque(false); 

        subjectBox = new JComboBox<>(new String[]{"C", "Java", "DSA"});
        typeBox = new JComboBox<>(new String[]{"MCQ", "TrueFalse"});

        topPanel.add(new JLabel("Subject:"));
        topPanel.add(subjectBox);
        topPanel.add(new JLabel("Type:"));
        topPanel.add(typeBox);

      
        textArea = new JTextArea(50, 90);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setOpaque(false); 

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setOpaque(false);

        loadButton = createGradientButton("Load");
        saveButton = createGradientButton("Save");
        backButton = createGradientButton("Back");

        bottomPanel.add(loadButton);
        bottomPanel.add(saveButton);
        bottomPanel.add(backButton);

        loadButton.addActionListener(e -> loadFile());
        saveButton.addActionListener(e -> saveFile());
        backButton.addActionListener((ActionEvent e) ->{
           new AdminPass().setVisible(true);
           dispose();
        });
        
        setLayout(new BorderLayout(10, 10));
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    private JButton createGradientButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        return button;
    }

   
    private void loadFile() {
        String subject = subjectBox.getSelectedItem().toString().toLowerCase();
        String type = typeBox.getSelectedItem().toString().toLowerCase();
        String filePath = BASE_PATH + subject + "/" + type + ".json";
        try {
            String content = Files.readString(Paths.get(filePath));
            textArea.setText(content);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "File not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFile() {
        String subject = subjectBox.getSelectedItem().toString().toLowerCase();
        String type = typeBox.getSelectedItem().toString().toLowerCase();
        String filePath = BASE_PATH + subject + "/" + type + ".json";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "File saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

  
}