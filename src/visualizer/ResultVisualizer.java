package visualizer;

import chart.BarChart;
import chart.PieChart;
import manager.ChartManager;

import java.util.Map;

public class ResultVisualizer {

    public static void showPieChart(String username) {
        int[] result = ChartManager.getCorrectVsWrong(username);
        new PieChart(username, result[0], result[1]).setVisible(true);
    }

    public static void showBarChart(String username) {
        Map<String, Integer> scores = ChartManager.getSubjectWiseScores(username);
        int c = scores.getOrDefault("C", 0);
        int dsa = scores.getOrDefault("DSA", 0);
        int java = scores.getOrDefault("Java", 0);
        new BarChart(c, dsa, java).setVisible(true);
    }
}
