package ru.skypro.hw.coursework.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.hw.coursework.coursework2.domain.Question;
import ru.skypro.hw.coursework.coursework2.repository.QuestionRepository;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {


    private QuestionRepository questionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public int getSize() {
        return questionRepository.getAll().size();
    }

    @Override
    public Question add(String question, String answer) {
        Question addQuestion = new Question(question, answer);
        questionRepository.add(addQuestion);
        return addQuestion;
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question removeQuestion = new Question(question, answer);
        if (!questionRepository.getAll().contains(removeQuestion)) {
            throw new IllegalArgumentException();
        }
        questionRepository.remove(removeQuestion.getQuestion(), removeQuestion.getAnswer());
        return removeQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> question = questionRepository.getAll().stream().toList();
        return question.get(random.nextInt(getSize()));
    }


}
