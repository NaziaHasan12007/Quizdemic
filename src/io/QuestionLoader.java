package io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.MultipleChoiceQuestion;
import model.TrueFalseQuestion;
import model.Question;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class QuestionLoader {
    public static List<Question> loadQuestions(String path, String type) throws Exception {
        Gson gson = new Gson();
        FileReader reader = new FileReader(path);
        List<Question> list = new ArrayList<>();

        if (type.equals("MCQ")) {
            Type listType = new TypeToken<List<MultipleChoiceQuestion>>() {}.getType();
            list.addAll(gson.fromJson(reader, listType));
        } 
        else if(type.equals("True-False")){
            Type listType = new TypeToken<List<TrueFalseQuestion>>() {}.getType();
            list.addAll(gson.fromJson(reader, listType));
        }

        reader.close();
        return list;
    }
}
