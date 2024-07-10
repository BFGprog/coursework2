package ru.skypro.hw.coursework.coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.hw.coursework.coursework2.domain.Question;
import ru.skypro.hw.coursework.coursework2.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {
    private ExaminerService examinerService;
    public ExamController(ExaminerService examinerService){
        this.examinerService = examinerService;
    }

    @GetMapping("/question")
    public Collection<Question> getQuestions(@RequestParam int amount){
        return examinerService.getQuestions(amount);
    }
}
