package ru.skypro.hw.coursework.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.hw.coursework.coursework2.domain.Question;
import ru.skypro.hw.coursework.coursework2.exception.MethodNotSupportedException;
import ru.skypro.hw.coursework.coursework2.repository.MathQuestionRepository;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

//    @Mock
//    MathQuestionRepository mathQuestionRepository;
//
//    @InjectMocks
    MathQuestionService mathQuestionService = new MathQuestionService();

    @Test
    void add() {
        // Give
        Question question = new Question("Test", "Test");
        // When
        // Then
        assertThrows(MethodNotSupportedException.class, () -> mathQuestionService.add(question));
    }

    @Test
    void testAdd() {
        // Given
        // When
        // Then
        assertThrows(MethodNotSupportedException.class, () -> mathQuestionService.add("Test", "Test"));
    }

    @Test
    void remove() {
        // Given
        // When
        // Then
        assertThrows(MethodNotSupportedException.class, () -> mathQuestionService.add("Test", "Test"));
    }




    @Test
    void getAll() {
        // Given
        // When
        // Then
        assertThrows(MethodNotSupportedException.class, () -> mathQuestionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        // Given
        // When
        // Then
    }
}