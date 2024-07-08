package ru.skypro.hw.coursework.coursework2.service;

import org.springframework.stereotype.Service;
import ru.skypro.hw.coursework.coursework2.domain.Question;
import ru.skypro.hw.coursework.coursework2.exception.ExceedingTheListException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
//        Random random = new Random();
//        List<Question> questionsAll = new ArrayList<>(questionService.getAll());
//        List<Question> questions = new ArrayList<>();
//        if(amount > questionsAll.size()){
//            throw new ExceedingTheListException();
//        }
//        for (; questions.size() < amount; ) {
//            Question question = questionsAll.get(random.nextInt(questionsAll.size()));
//            if (!questions.contains(question))
//                questions.add(question);
//        }
//        return questions;

        if(amount > questionService.getSize()){
            throw new ExceedingTheListException();
        }
        List<Question> questions2 = new ArrayList<>();
        for (; questions2.size() < amount; ) {
            Question question = questionService.getRandomQuestion();
            if (!questions2.contains(question))
                questions2.add(question);
        }
        return questions2;
    }

}
