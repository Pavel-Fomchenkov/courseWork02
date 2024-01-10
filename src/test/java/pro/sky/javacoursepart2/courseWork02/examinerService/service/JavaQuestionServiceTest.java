package pro.sky.javacoursepart2.courseWork02.examinerService.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import pro.sky.javacoursepart2.courseWork02.examinerService.domain.Question;
import pro.sky.javacoursepart2.courseWork02.examinerService.domain.QuestionRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class JavaQuestionServiceTest {
    private final QuestionRepository questionRepository = Mockito.mock(QuestionRepository.class);
    @InjectMocks
    private JavaQuestionService repository = new JavaQuestionService(questionRepository);

    @Test
    void getRandomQuestionShouldReturnOneRandomQuestion() {
        when(repository.getAll()).thenReturn(List.of(
                new Question("Question1", "Answer1"),
                new Question("Question2", "Answer2"),
                new Question("Question3", "Answer3"),
                new Question("Question4", "Answer4")
        ));
//        System.out.println(repository.getRandomQuestion() + " - should be random from Question1 to Question4");
        assertTrue(repository.getAll().contains(repository.getRandomQuestion()));
    }
}