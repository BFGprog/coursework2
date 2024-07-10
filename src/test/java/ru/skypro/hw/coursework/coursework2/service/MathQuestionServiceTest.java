package ru.skypro.hw.coursework.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.hw.coursework.coursework2.domain.Question;
import ru.skypro.hw.coursework.coursework2.repository.MathQuestionRepository;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    MathQuestionRepository mathQuestionRepository;

    @InjectMocks
    MathQuestionService mathQuestionService = new MathQuestionService(mathQuestionRepository);

    @Test
    void add() {
        // Give
        Question expected = new Question("Test", "Test");
        // When
        Question actual = mathQuestionService.add("Test", "Test");
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void testAdd() {
        // Given
        Question expected = new Question("Test", "Test");
        // When
        Question actual = mathQuestionService.add(expected);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        // Given
        Question expected = new Question("Test", "Test");
        Collection<Question> questions = Set.of(expected);
        // When
        Mockito.when(mathQuestionService.getAll()).thenReturn(questions);
        Mockito.when(mathQuestionService.remove("Test", "Test")).thenReturn(expected);
        Question actual = mathQuestionService.remove("Test", "Test");
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void removeException() {
        // Given
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> mathQuestionService.remove("Test", "Test"));
    }


    @Test
    void getAll() {
        // Given
        Collection<Question> expected = Set.of(new Question("Test", "Test"), new Question("Test1", "Test"));
        // When
        Mockito.when(mathQuestionService.getAll()).thenReturn(expected);
        Collection<Question> actual = mathQuestionService.getAll();
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