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

    @InjectMocks
    private ExaminerServiceImpl examinerService;


    @Test
    void getQuestions() {
        // Give
        Collection<Question> expected = Set.of(new Question("Test1", "Test"));
        int amount = 1;

        // When
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(new Question("Test1", "Test"));
        Mockito.when(javaQuestionService.getSize()).thenReturn(amount);
        Collection<Question> actual = examinerService.getQuestions(amount);
        // Then
        Assertions.assertThat(expected).containsExactlyInAnyOrderElementsOf(actual);
    }

    @Test
    void getQuestionsException() {
        // Give
        int amount = 3;
        // When
        Mockito.when(javaQuestionService.getSize()).thenReturn(amount - 1);
        // Then
        assertThrows(ExceedingTheListException.class, () -> examinerService.getQuestions(amount));
    }
}