package ru.skypro.hw.coursework.coursework2.repository;

import ru.skypro.hw.coursework.coursework2.domain.Question;

import java.util.Collection;

public interface QuestionRepository {


    public Question add(Question question);
    public Question remove(String question, String answer);
    public Collection<Question> getAll();
}
