package model;

import java.util.ArrayList;
import java.util.List;

public class QuizSession {
    private String username;
    private String subject;
    private String questionType; // "MCQ" or "TF"
    private List<Question> questions;
    private List<String> userAnswers = new ArrayList<>();
    private long startTime;
    private long endTime;

    public QuizSession(String username, String subject, String questionType, List<Question> questions) {
        this.username = username;
        this.subject = subject;
        this.questionType = questionType;
        this.questions = questions;
        this.startTime = System.currentTimeMillis();
    }

    public void addAnswer(String answer) {
        if(userAnswers.size() <= getCurrentIndex()){
            userAnswers.add(answer);
        } 
    }

    public void removeLastAnswer() {
       if (!userAnswers.isEmpty()) {
           userAnswers.remove(userAnswers.size() - 1);
       }
    }

    public int getCorrectAnswerCount() {
       int count = 0;
       for (int i = 0; i < userAnswers.size(); i++) {
           String answer = userAnswers.get(i);
           if (answer != null && questions.get(i).isCorrect(answer)) {
               count++;
           }
        }
        return count;
    }

    public int getWrongAnswerCount() {
        int count = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            String answer = userAnswers.get(i);
            if (answer != null && !questions.get(i).isCorrect(answer)) {
                count++;
            }
        }
        return count;
    }

    public int getSkippedCount() {
        int count = 0;
        for (String answer : userAnswers) {
            if (answer == null) {
                count++;
            }
        }
        return count;
    }

    public double getFinalMarks() {
        return getCorrectAnswerCount() - 0.25 * getWrongAnswerCount();
    }

    public long getTimeTakenInSeconds() {
        return (endTime - startTime) / 1000;
    }

    public void endSession() {
        this.endTime = System.currentTimeMillis();
    }

    public int getCurrentIndex() {
        return userAnswers.size();
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<String> getUserAnswers() {
        return userAnswers;
    }

    public String getUsername() {
        return username;
    }

    public String getSubject() {
        return subject;
    }

    public String getQuestionType() {
        return questionType;
    }
}
