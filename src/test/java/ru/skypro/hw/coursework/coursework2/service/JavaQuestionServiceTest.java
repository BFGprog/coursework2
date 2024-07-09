package ru.skypro.hw.coursework.coursework2.service;

import org.junit.jupiter.api.Test;
import ru.skypro.hw.coursework.coursework2.domain.Question;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    JavaQuestionService javaQuestionService = new JavaQuestionService();


    @Test
    void add() {
        // Give
        Question expected = new Question("Test", "Test");
        // When
        Question actual = javaQuestionService.add("Test", "Test");
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void testAdd() {
        // Given
        Question expected = new Question("Test", "Test");
        // When
        Question actual = javaQuestionService.add(expected);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        // Given
        Question expected = new Question("Test", "Test");
        javaQuestionService.add("Test", "Test");
        // When
        Question actual = javaQuestionService.remove("Test", "Test");
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void removeException() {
        // Given
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> javaQuestionService.remove("Test", "Test"));
    }


    @Test
    void getAll() {
        // Given
        Collection<Question> expected =Set.of(new Question("Test", "Test"), new Question("Test1", "Test"));
        javaQuestionService.add("Test", "Test");
        javaQuestionService.add("Test1", "Test");
        // When
        Collection<Question> actual = javaQuestionService.getAll();
        // Then
        org.assertj.core.api.Assertions.assertThat(expected).containsExactlyInAnyOrderElementsOf(actual);
//        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion() {
        // Given
        // When
        // Then
    }
}