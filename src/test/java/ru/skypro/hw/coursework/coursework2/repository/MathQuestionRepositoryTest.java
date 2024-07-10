package ru.skypro.hw.coursework.coursework2.repository;

import org.junit.jupiter.api.Test;
import ru.skypro.hw.coursework.coursework2.domain.Question;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {

    MathQuestionRepository mathQuestionRepository = new MathQuestionRepository();

    @Test
    void add() {
        // Give
        Question expected = new Question("21 + 21 =", "42");
        // When
        Question actual = mathQuestionRepository.add(expected);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        // Given
        Question expected = new Question("21 / 21 =", "1");
        mathQuestionRepository.add(expected);
        // When
        Question actual = mathQuestionRepository.remove("21 / 21 =", "1");
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        // Given
        Collection<Question> expected = Set.of(new Question("2 * 6 =", "12"), new Question("6 / 2 =", "3"));
        Question question1 = new Question("6 / 2 =", "3");
        Question question2 = new Question("2 * 6 =", "12");
        mathQuestionRepository.add(question1);
        mathQuestionRepository.add(question2);
        // When
        Collection<Question> actual = mathQuestionRepository.getAll();
        // Then
        org.assertj.core.api.Assertions.assertThat(expected).containsExactlyInAnyOrderElementsOf(actual);
//        Assertions.assertEquals(expected, actual);
    }
}