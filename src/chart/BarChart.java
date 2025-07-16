package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class BarChart extends JFrame {

    public BarChart(int cScore, int dsaScore, int javaScore) {
        super("Subject-wise Performance");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(cScore, "Score", "C");
        dataset.setValue(dsaScore, "Score", "DSA");
        dataset.setValue(javaScore, "Score", "Java");

        JFreeChart chart = ChartFactory.createBarChart(
                "Subject-wise Quiz Scores",
                "Subject",
                "Marks",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}

