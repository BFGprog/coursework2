package ru.skypro.hw.coursework.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.hw.coursework.coursework2.domain.Question;
import ru.skypro.hw.coursework.coursework2.exception.ExceedingTheListException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;


    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> javaQuestions = new ArrayList<>(getJavaQuestions(amount));
        List<Question> mathQuestions = new ArrayList<>(getMathQuestions(amount));

        javaQuestions.addAll(mathQuestions);
        return javaQuestions;
    }

    @Override
    public Collection<Question> getJavaQuestions(int amount) {
        if (amount > javaQuestionService.getSize()) {
            throw new ExceedingTheListException();
        }
        Set<Question> javaQuestions = new HashSet<>();
        for (; javaQuestions.size() < amount; ) {
            Question question = javaQuestionService.getRandomQuestion();
            if (!javaQuestions.contains(question))
                javaQuestions.add(question);
        }
        return javaQuestions;
    }
    //

    @Override
    public Collection<Question> getMathQuestions(int amount) {
        if (amount > mathQuestionService.getSize()) {
            throw new ExceedingTheListException();
        }
        Set<Question> mathQuestions = new HashSet<>();
        for (; mathQuestions.size() < amount; ) {
            Question question = mathQuestionService.getRandomQuestion();
            if (!mathQuestions.contains(question))
                mathQuestions.add(question);
        }
        return mathQuestions;
    }

}
