
package io;

import model.QuizSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

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

    // Returns subject-wise total score for a user (rounded to int)
    public static Map<String, Integer> getUserScores(String username) {
        Map<String, Double> subjectScores = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("results.txt"))) {
            String line;
            String currentUser = "", subject = "";
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User: ")) {
                    currentUser = line.substring(6).trim();
                } else if (line.startsWith("Subject: ")) {
                    subject = line.substring(9).trim();
                } else if (line.startsWith("Score: ") && currentUser.equals(username)) {
                    String[] parts = line.substring(7).split("/");
                    double score = Double.parseDouble(parts[0].trim());
                    subjectScores.put(subject, subjectScores.getOrDefault(subject, 0.0) + score);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Convert double scores to int rounded values for chart display
        Map<String, Integer> roundedScores = new HashMap<>();
        for (Map.Entry<String, Double> entry : subjectScores.entrySet()) {
            roundedScores.put(entry.getKey(), (int) Math.round(entry.getValue()));
        }
        return roundedScores;
    }

    // Returns an int array: [correctAnswersCount, wrongAnswersCount] (rounded)
    public static int[] getCorrectWrong(String username) {
        double correct = 0.0;
        double total = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader("results.txt"))) {
            String line;
            String currentUser = "";
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User: ")) {
                    currentUser = line.substring(6).trim();
                } else if (line.startsWith("Score: ") && currentUser.equals(username)) {
                    String[] parts = line.substring(7).split("/");
                    correct += Double.parseDouble(parts[0].trim());
                    total += Double.parseDouble(parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int correctInt = (int) Math.round(correct);
        int wrongInt = (int) Math.round(total - correct);
        return new int[]{correctInt, wrongInt};
    }
}
