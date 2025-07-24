package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdminEditor extends BaseFrame {
    private JTextArea textArea;
    private JComboBox<String> subjectBox;
    private JComboBox<String> typeBox;
    private final String BASE_PATH = "src/data/question/";

    public AdminEditor() {
        super("Edit Question File");

        JLabel subjectLabel = new JLabel("Subject:");
        subjectBox = new JComboBox<>(new String[]{"C", "Java", "DSA"});

        JLabel typeLabel = new JLabel("Question Type:");
        typeBox = new JComboBox<>(new String[]{"mcq", "truefalse"});

        JButton loadButton = new JButton("Load File");
        JButton saveButton = new JButton("Save Changes");

        textArea = new JTextArea(25, 60);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel topPanel = new JPanel();
        topPanel.add(subjectLabel);
        topPanel.add(subjectBox);
        topPanel.add(typeLabel);
        topPanel.add(typeBox);
        topPanel.add(loadButton);
        topPanel.add(saveButton);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Action Listeners
        loadButton.addActionListener((ActionEvent e) -> loadFile());
        saveButton.addActionListener((ActionEvent e) -> saveFile());
    }

    private void loadFile() {
        String subject = subjectBox.getSelectedItem().toString().toLowerCase();
        String type = typeBox.getSelectedItem().toString().toLowerCase();
        String path = BASE_PATH + subject + "/" + type + ".json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            textArea.setText(content);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load file: " + ex.getMessage());
        }
    }

    private void saveFile() {
        String subject = subjectBox.getSelectedItem().toString().toLowerCase();
        String type = typeBox.getSelectedItem().toString().toLowerCase();
        String path = BASE_PATH + subject + "/" + type + ".json";

        try (FileWriter writer = new FileWriter(path)) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "File saved successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to save file: " + ex.getMessage());
        }
    }
}

