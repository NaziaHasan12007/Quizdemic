package io;

import model.QuizSession;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultManager {
    public static void saveResult(QuizSession session) {
        String filename = "results.txt";  // or one per user: "results_username.txt"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("User: " + session.getUsername());
            writer.newLine();
            writer.write("Subject: " + session.getSubject());
            writer.newLine();
            writer.write("Type: " + session.getQuestionType());
            writer.newLine();
            writer.write("Score: " + session.getFinalMarks() + " / " + session.getTotalQuestions());
            writer.newLine();
            writer.write("Answers: " + session.getUserAnswers());
            writer.newLine();
            writer.write("-------------------------------");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
