package com.javarush.quest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.quest.entity.Question;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestService {
    private Map<Integer, Question> questions = new HashMap<>();

    public QuestService() {
        loadQuestions();
    }

    private void loadQuestions() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions.json");
            QuestionList questionList = mapper.readValue(inputStream, QuestionList.class);

            questionList.getQuestions().forEach(q -> questions.put(q.getId(), q));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Question getQuestion(int id) {
        return questions.get(id);
    }

    private static class QuestionList {
        private List<Question> questions;

        public List<Question> getQuestions() { return questions; }
    }
}

