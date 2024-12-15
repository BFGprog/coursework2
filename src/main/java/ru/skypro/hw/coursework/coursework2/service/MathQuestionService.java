package ru.skypro.hw.coursework.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.hw.coursework.coursework2.domain.Question;
import ru.skypro.hw.coursework.coursework2.exception.MethodNotSupportedException;
import ru.skypro.hw.coursework.coursework2.repository.QuestionRepository;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {


//    private QuestionRepository questionRepository;
//
//    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
//        this.questionRepository = questionRepository;
//    }


    @Override
    public int getSize() {
//        return questionRepository.getAll().size();
        throw new MethodNotSupportedException();
    }

    @Override
    public Question add(String question, String answer) {
//        Question addQuestion = new Question(question, answer);
//        questionRepository.add(addQuestion);
//        return addQuestion;
        throw new MethodNotSupportedException();
    }

    @Override
    public Question add(Question question) {
//        questionRepository.add(question);
//        return question;
        throw new MethodNotSupportedException();
    }

    @Override
    public Question remove(String question, String answer) {
//        Question removeQuestion = new Question(question, answer);
//        if (!questionRepository.getAll().contains(removeQuestion)) {
//            throw new IllegalArgumentException();
//        }
//        questionRepository.remove(removeQuestion.getQuestion(), removeQuestion.getAnswer());
//        return removeQuestion;
        throw new MethodNotSupportedException();
    }

    @Override
    public Collection<Question> getAll() {
//        return questionRepository.getAll();
        throw new MethodNotSupportedException();
    }

    @Override
    public Question getRandomQuestion() {
        Question question = new Question(" ", " ");
        Random random = new Random();
        int num1 = random.nextInt(1_000);
        int num2 = random.nextInt(1_000);
        int result;

        switch (random.nextInt(4)) {
            case 0:
                result = num1 + num2;
                question = new Question(num1 + " + " + num2, result + "");
                break;

            case 1:
                result = num1 - num2;
                question = new Question(num1 + " - " + num2, result + "");
                break;

            case 2:
                result = num1 * num2;
                question = new Question(num1 + " * " + num2, result + "");
                break;

            case 3:
                if (num2 == 0) {
                    num2++;
                }
                double resultD = (double) num1 / num2;
                question = new Question(num1 + " / " + num2, resultD + "");
                break;

        }
        return question;
    }


}
