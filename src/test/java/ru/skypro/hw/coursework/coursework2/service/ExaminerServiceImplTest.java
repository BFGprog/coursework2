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
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {


    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

//    private final JavaQuestionService javaQuestionService = mock(JavaQuestionService.class);
//    private final MathQuestionService mathQuestionService  = mock(MathQuestionService.class);

//    private ExaminerServiceImpl examinerServiceJava;
//    private ExaminerServiceImpl examinerServiceMath;
//
//    @BeforeEach
//    public void setUp() {
//        examinerServiceJava = new ExaminerServiceImpl(javaQuestionService);
//        examinerServiceMath = new ExaminerServiceImpl(mathQuestionService);
//    }


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
        Collection<Question> expected22 = Set.of(new Question("2+2=", "4"));
        int amount = 1;
        // When
        Mockito.when(mathQuestionService.getRandomQuestion()).thenReturn(new Question("2+2=", "4"));
        Collection<Question> actual = examinerService.getMathQuestions(amount);
        // Then
        assertEquals(expected22, actual);
//        Assertions.assertThat(expected22).containsExactlyInAnyOrderElementsOf(actual);
    }

}