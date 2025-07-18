package model;
import com.google.gson.annotations.SerializedName;
public abstract class Question {
    @SerializedName("question")
    protected String questionText;
    @SerializedName("answer")
    protected String correctAnswer;

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public abstract boolean isCorrect(String userAnswer);
}
