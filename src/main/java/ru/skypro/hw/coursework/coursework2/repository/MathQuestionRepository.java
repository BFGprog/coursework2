package ru.skypro.hw.coursework.coursework2.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.skypro.hw.coursework.coursework2.domain.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void input() {
        add(new Question("2 + 2 = ", "4"));
        add(new Question("2 + 3 = ", "5"));
        add(new Question("4 + 2 = ", "6"));
        add(new Question("2 * 2 = ", "4"));
        add(new Question("2 * 5 = ", "10"));
        add(new Question("2 / 2 = ", "1"));
        add(new Question("5 / 2 = ", "2.5"));
        add(new Question("26 / 2 = ", "13"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question removeQuestion = new Question(question, answer);
        if (!questions.contains(removeQuestion)){
            throw new IllegalArgumentException();
        }
        questions.remove(removeQuestion);
        return removeQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }

}
