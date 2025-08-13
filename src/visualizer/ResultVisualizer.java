
package visualizer;

import chart.BarChart;
import chart.PieChart;
import manager.ChartManager;

public class ResultVisualizer {

    public static void showPieChart(String username) {
        int[] result = ChartManager.getCorrectVsWrong(username);
        new PieChart(username, result[0], result[1]).setVisible(true);
    }

    public static void showBarChart(String username) {
        new BarChart("results.txt").setVisible(true);
    }
}

