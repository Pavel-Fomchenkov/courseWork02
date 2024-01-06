package pro.sky.javacoursepart2.courseWork02.examinerService.service;

import org.junit.jupiter.api.Test;
import pro.sky.javacoursepart2.courseWork02.examinerService.domain.Question;
import pro.sky.javacoursepart2.courseWork02.examinerService.exceptions.BannedMethodException;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceTest {
    private final MathQuestionService out = new MathQuestionService();

    @Test
    void allMethodsShouldThrowBannedMethodException() {
        assertThrows(BannedMethodException.class, () -> out.add("Вопрос", "Ответ"));
        assertThrows(BannedMethodException.class, () -> out.add(new Question("Вопрос", "Ответ")));
        assertThrows(BannedMethodException.class, () -> out.remove("Вопрос", "Ответ"));
        assertThrows(BannedMethodException.class, () -> out.getAll());
    }
}