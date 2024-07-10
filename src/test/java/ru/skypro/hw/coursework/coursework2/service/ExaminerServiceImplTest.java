package ru.skypro.hw.coursework.coursework2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.hw.coursework.coursework2.domain.Question;
import ru.skypro.hw.coursework.coursework2.exception.ExceedingTheListException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;


    @Test
    void getQuestions() {
        // Give

        // When

        // Then
    }

    @Test
    void getJavaQuestionsException() {
        // Give
        int amount = 3;
        // When
        Mockito.when(javaQuestionService.getSize()).thenReturn(amount - 1);
        // Then
        assertThrows(ExceedingTheListException.class, () -> examinerService.getJavaQuestions(amount));
    }
    @Test
    void getJavaQuestions() {
        // Give
        Collection<Question> expected = Set.of(new Question("Test1", "Test"));
        int amount = 1;
        // When
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(new Question("Test1", "Test"));
        Mockito.when(javaQuestionService.getSize()).thenReturn(amount);
        Collection<Question> actual = examinerService.getJavaQuestions(amount);
        // Then
        Assertions.assertThat(expected).containsExactlyInAnyOrderElementsOf(actual);
    }

    @Test
    void getMathQuestions() {
        // Give
        Collection<Question> expected = Set.of(new Question("2+2=", "4"));
        int amount = 1;
        // When
        Mockito.when(mathQuestionService.getRandomQuestion()).thenReturn(new Question("2+2=", "4"));
        Mockito.when(mathQuestionService.getSize()).thenReturn(amount);
        Collection<Question> actual = examinerService.getMathQuestions(amount);
        // Then
        Assertions.assertThat(expected).containsExactlyInAnyOrderElementsOf(actual);
    }

    @Test
    void getMathQuestionsException() {
        // Give
        int amount = 3;
        // When
        Mockito.when(mathQuestionService.getSize()).thenReturn(amount - 1);
        // Then
        assertThrows(ExceedingTheListException.class, () -> examinerService.getJavaQuestions(amount));
    }
}