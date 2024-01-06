package pro.sky.javacoursepart2.courseWork02.examinerService.domain;

import org.junit.jupiter.api.Test;
import pro.sky.javacoursepart2.courseWork02.examinerService.exceptions.AlreadyAddedException;
import pro.sky.javacoursepart2.courseWork02.examinerService.exceptions.QuestionNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    private JavaQuestionRepository out = new JavaQuestionRepository();

    @Test
    void addStringsParamsShouldAddNewQuestionToCollection() {
        out.add("Вопрос", "Ответ");
        Question o = new Question("Вопрос", "Ответ");
        assertTrue(out.getAll().contains(o));
        assertThrows(AlreadyAddedException.class, () -> out.add("Вопрос", "Ответ"));
    }

    @Test
    void addQuestionParamShouldAddNotExistedQuestionToCollection() {
        Question o = new Question("Вопрос", "Ответ");
        out.add(o);
        assertTrue(out.getAll().contains(o));
        assertThrows(AlreadyAddedException.class, () -> out.add(o));
    }

    @Test
    void removeShouldRemoveQuestionFromCollection() {
        out.add("Вопрос", "Ответ");
        out.add("Вопрос1", "Ответ1");
        out.add("Вопрос2", "Ответ2");
        out.remove("Вопрос1", "Ответ1");
        assertFalse(out.getAll().contains(new Question("Вопрос1", "Ответ1")));
        assertThrows(QuestionNotFoundException.class, () -> out.remove("Вопрос1", "Ответ1"));
    }

    @Test
    void getAll() {
        out.add("Вопрос", "Ответ");
        out.add("Вопрос1", "Ответ1");
        out.add("Вопрос2", "Ответ2");
        assertTrue(out.getAll().contains(new Question("Вопрос", "Ответ")));
        assertTrue(out.getAll().contains(new Question("Вопрос1", "Ответ1")));
        assertTrue(out.getAll().contains(new Question("Вопрос2", "Ответ2")));
    }
}