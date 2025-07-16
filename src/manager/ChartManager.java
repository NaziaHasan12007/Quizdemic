package manager;

import io.ResultManager;
import java.util.Map;

public class ChartManager {

    public static Map<String, Integer> getSubjectWiseScores(String username) {
        return ResultManager.getUserScores(username);
    }

    public static int[] getCorrectVsWrong(String username) {
        return ResultManager.getCorrectWrong(username);
    }
}

