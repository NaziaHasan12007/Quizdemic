package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

public class PieChart extends JFrame {

    public PieChart(String username, int correct, int wrong) {
        super("Individual Result - " + username);

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Correct", correct);
        dataset.setValue("Wrong", wrong);

        JFreeChart chart = ChartFactory.createPieChart(
                "Accuracy - " + username,
                dataset,
                true, true, false
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
