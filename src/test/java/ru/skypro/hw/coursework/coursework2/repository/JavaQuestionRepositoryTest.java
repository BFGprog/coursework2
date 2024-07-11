package ru.skypro.hw.coursework.coursework2.repository;

import org.junit.jupiter.api.Test;
import ru.skypro.hw.coursework.coursework2.domain.Question;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {

    JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();

    @Test
    void add() {
        // Give
        Question expected = new Question("Test", "Test");
        // When
        Question actual = javaQuestionRepository.add(expected);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        // Given
        Question expected = new Question("Test", "Test");
        javaQuestionRepository.add(expected);
        // When
        Question actual = javaQuestionRepository.remove("Test", "Test");
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        // Given
        Collection<Question> expected = Set.of(new Question("Test1", "Test"), new Question("Test2", "Test"));
        Question question1 = new Question("Test1", "Test");
        Question question2 = new Question("Test2", "Test");
        javaQuestionRepository.add(question1);
        javaQuestionRepository.add(question2);
        // When
        Collection<Question> actual = javaQuestionRepository.getAll();
        // Then
        org.assertj.core.api.Assertions.assertThat(expected).containsExactlyInAnyOrderElementsOf(actual);
//        Assertions.assertEquals(expected, actual);
    }
}