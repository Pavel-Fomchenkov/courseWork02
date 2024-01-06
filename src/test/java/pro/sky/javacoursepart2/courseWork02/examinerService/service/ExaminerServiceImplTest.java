package pro.sky.javacoursepart2.courseWork02.examinerService.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pro.sky.javacoursepart2.courseWork02.examinerService.domain.Question;
import pro.sky.javacoursepart2.courseWork02.examinerService.exceptions.WrongAmountException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {
    private final QuestionService javaQuestionService = Mockito.mock(QuestionService.class);
    private final QuestionService mathQuestionService = Mockito.mock(QuestionService.class);
    private final ExaminerServiceImpl out = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);

    @Test
    void getQuestionsTest() {
        int i = 0;
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(new Question("jq" + ++i, "ja"))
                .thenReturn(new Question("jq" + ++i, "ja"))
                .thenReturn(new Question("jq" + ++i, "ja"))
                .thenReturn(new Question("jq" + ++i, "ja"))
                .thenReturn(new Question("jq" + ++i, "ja"));
        when(mathQuestionService.getRandomQuestion())
                .thenReturn(new Question("mq" + ++i, "ma"))
                .thenReturn(new Question("mq" + ++i, "ma"))
                .thenReturn(new Question("mq" + ++i, "ma"))
                .thenReturn(new Question("mq" + ++i, "ma"))
                .thenReturn(new Question("mq" + ++i, "ma"));
        assertThrows(WrongAmountException.class, () -> out.getQuestions(0));
        assertThrows(WrongAmountException.class, () -> out.getQuestions(-1));
        assertEquals(5, out.getQuestions(5).size());
        assertEquals(5, out.getQuestions(5)
                        .stream().distinct().count());
    }
}