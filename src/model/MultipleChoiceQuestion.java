package model;

public class MultipleChoiceQuestion extends Question {
    private String[] options;

    public MultipleChoiceQuestion(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Required for Gson (must have a no-arg constructor)
    public MultipleChoiceQuestion() {}

    public String[] getOptions() {
        return options;
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }
}

