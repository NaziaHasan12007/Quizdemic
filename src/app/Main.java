package app;

import com.google.gson.Gson;
import model.Question;
import ui.SplashScreen;

import java.io.FileReader;


public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            SplashScreen splash = new SplashScreen();
            splash.showSplash();
        });

        loadQuestions();
    }

    public static void loadQuestions() {
        try {
            Gson gson = new Gson();

            FileReader reader = new FileReader("D:\\Quizdemic\\src\\data\\question\\c\\mcq.json");

            // InputStreamReader reader = new InputStreamReader(input);
            Question[] questions = gson.fromJson(reader, Question[].class);

            for (Question q : questions) {
                System.out.println("Q: " + q.toString());
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
}

