package pro.sky.javacoursepart2.courseWork02.examinerService.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pro.sky.javacoursepart2.courseWork02.examinerService.exceptions.AlreadyAddedException;
import pro.sky.javacoursepart2.courseWork02.examinerService.exceptions.BannedMethodException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Repository
@Qualifier("math")
public class MathQuestionRepository implements QuestionRepository {
    private Collection<Question> repository = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        throw new BannedMethodException("Method \"add\" is banned for math questions");
    }

    @Override
    public Question add(Question question) {
        throw new BannedMethodException("Method \"add\" is banned for math questions");
    }

    @Override
    public Question remove(String question, String answer) {
        throw new BannedMethodException("Method \"remove\" is banned for math questions");
    }

    @Override
    public Collection<Question> getAll() {
        throw new BannedMethodException("This method is banned for math questions");
    }
}
