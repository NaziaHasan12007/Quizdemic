
package io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.MultipleChoiceQuestion;
import model.TrueFalseQuestion;
import model.Question;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionLoader {

    public static List<Question> loadQuestions(String subject, String type) throws Exception {
        if (subject == null || subject.isBlank() || type == null || type.isBlank()) {
            throw new IllegalArgumentException("Subject and type must not be empty.");
        }

        type = type.trim().toLowerCase();
        subject = subject.trim().toLowerCase();

        
        String path = "src/data/question/" + subject + "/" + type + ".json";

        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found: " + file.getAbsolutePath());
        }

        Gson gson = new Gson();
        List<? extends Question> tempList;

        switch (type) {
            case "mcq":
                Type mcqListType = new TypeToken<List<MultipleChoiceQuestion>>() {}.getType();
                tempList = gson.fromJson(new FileReader(file), mcqListType);
                break;

            case "truefalse":
                Type tfListType = new TypeToken<List<TrueFalseQuestion>>() {}.getType();
                tempList = gson.fromJson(new FileReader(file), tfListType);
                break;

            default:
                throw new IllegalArgumentException("Unsupported question type: " + type);
        }

        List<Question> questions = new ArrayList<>(tempList);
        Collections.shuffle(questions);

        
        return questions.subList(0, Math.min(30, questions.size()));
    }

    
}