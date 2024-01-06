package pro.sky.javacoursepart2.courseWork02.examinerService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.javacoursepart2.courseWork02.examinerService.domain.Question;
import pro.sky.javacoursepart2.courseWork02.examinerService.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping()
    public String Hello() {
        return "Доступные команды:" +
                "<br> '/get/количество вопросов' - получить указанное количество случайных вопросов;" +
                "<br> '/java' - просмотр доступных вопросов по java;" +
                "<br> '/java/add?question=Текст вопроса&answer=Текст ответа' - добавить свой вопрос по java;" +
                "<br> '/java/remove?question=Текст вопроса&answer=Текст ответа' - удалить вопрос по java;";
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }

}
