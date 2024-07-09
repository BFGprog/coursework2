package ru.skypro.hw.coursework.coursework2.service;

import ru.skypro.hw.coursework.coursework2.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    public Collection<Question> getQuestions(int amount);

}
