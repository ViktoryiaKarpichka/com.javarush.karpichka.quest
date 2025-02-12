package com.javarush.quest.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.javarush.quest.entity.Question;

public class QuestServiceTest {
    private QuestService questService;

    @BeforeEach
    void setUp() {
        questService = new QuestService();
    }

    @Test
    void testGetFirstQuestion() {
        Question question = questService.getQuestion(1);

        assertNotNull(question, "Первый вопрос не должен быть null");
        assertEquals("Ты потерял память. Принять вызов НЛО?", question.getText(), "Текст первого вопроса не совпадает");
    }

    @Test
    void testGetNextQuestion() {
        Question question = questService.getQuestion(2);

        assertNotNull(question, "Следующий вопрос не должен быть null");
        assertEquals("Ты принял вызов. Поднимаешься на мостик к капитану?", question.getText(), "Текст второго вопроса не совпадает");
    }

    @Test
    void testInvalidQuestionId() {
        Question question = questService.getQuestion(999);

        assertNull(question, "Для несуществующего ID должен возвращаться null");
    }
}