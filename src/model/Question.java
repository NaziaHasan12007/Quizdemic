package model;

public class Question {
    String question;

    public Question(){

    }

    @Override
    public String toString() {
        return "Question [question=" + question + "]";
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
