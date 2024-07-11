package ru.skypro.hw.coursework.coursework2.service;

import ru.skypro.hw.coursework.coursework2.domain.Question;

import java.util.Collection;

public interface QuestionService {

    public Question add(String question, String answer);
    public Question add(Question question);
    public Question remove(String question, String answer);
    public Collection<Question> getAll();
    public Question getRandomQuestion();
    public int getSize();



}
