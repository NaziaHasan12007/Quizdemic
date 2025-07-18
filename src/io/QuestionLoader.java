package io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.MultipleChoiceQuestion;
import model.TrueFalseQuestion;
import model.Question;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionLoader {
    public static List<Question> loadQuestions(String subject, String type) throws Exception {
        String path = "src/data/question/" + subject.toLowerCase() + "/" + type.toLowerCase() + ".json";

        Gson gson = new Gson();
        FileReader reader = new FileReader(path);
        List<Question> list = new ArrayList<>();
        type = type.trim().toLowerCase();

        if (type.equals("mcq")) {
            Type listType = new TypeToken<List<MultipleChoiceQuestion>>() {}.getType();
            list.addAll(gson.fromJson(reader, listType));
        } else if (type.equals("truefalse")) {
            Type listType = new TypeToken<List<TrueFalseQuestion>>() {}.getType();
            list.addAll(gson.fromJson(reader, listType));
        } else {
            throw new IllegalArgumentException("Unsupported question type: " + type);
        }

        reader.close();
        Collections.shuffle(list);
        return list.subList(0, Math.min(30, list.size()));
    }
}
