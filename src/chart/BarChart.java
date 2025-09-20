
package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BarChart extends JFrame {

    public BarChart(String filePath) {
        super("Subject-wise Total Scores");

        DefaultCategoryDataset dataset = createDatasetFromFile(filePath);

        if (dataset.getRowCount() == 0 || dataset.getColumnCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "No data found to plot. Please check result.txt path and format.");
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Total Scores per Subject",
                "Subject",
                "Total Score",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private DefaultCategoryDataset createDatasetFromFile(String filePath) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Double> subjectScores = new HashMap<>();

        File file = new File(filePath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "File not found: " + file.getAbsolutePath());
            return dataset;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String currentSubject = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();


                if (line.toLowerCase().startsWith("subject:")) {
                    currentSubject = line.substring(8).trim().toUpperCase();
                }

                else if (line.toLowerCase().startsWith("score:")) {
                    if (currentSubject == null) continue; // skip scores without subject

                    try {

                        String scorePart = line.substring(6).split("/")[0].trim();


                        double score = Double.parseDouble(scorePart);


                        subjectScores.put(
                                currentSubject,
                                subjectScores.getOrDefault(currentSubject, 0.0) + score
                        );
                    } catch (Exception e) {
                        System.out.println("⚠️ Error parsing score in line: " + line);
                    }
                }
            }


            for (Map.Entry<String, Double> entry : subjectScores.entrySet()) {
                System.out.println("✅ Parsed: " + entry.getKey() + " → " + entry.getValue());
                dataset.setValue(entry.getValue(), "Score", entry.getKey());
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
        }

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            new BarChart("D:/Quizdemic/results.txt").setVisible(true);
        });
    }
}