package ru.skypro.hw.coursework.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.hw.coursework.coursework2.domain.Question;
import ru.skypro.hw.coursework.coursework2.repository.JavaQuestionRepository;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    JavaQuestionService javaQuestionService = new JavaQuestionService(javaQuestionRepository);


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
        Collection<Question> questions = Set.of(expected);
        // When
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(questions);
        Mockito.when(javaQuestionRepository.remove("Test", "Test")).thenReturn(expected);
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
        Collection<Question> expected = Set.of(new Question("Test", "Test"), new Question("Test1", "Test"));
        // When
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(expected);
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