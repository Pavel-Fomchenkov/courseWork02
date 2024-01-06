package pro.sky.javacoursepart2.courseWork02.examinerService.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.javacoursepart2.courseWork02.examinerService.domain.Question;
import pro.sky.javacoursepart2.courseWork02.examinerService.exceptions.BannedMethodException;

import java.util.Collection;
import java.util.Random;

@Service
@Qualifier("math")
public class MathQuestionService implements QuestionService {

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

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        String[] action = {"+", "-", "*", "/"};
        int a, b, i, x;
        do {
            a = r.nextInt(30) - 15;
        } while (a == 0);
        do {
            b = r.nextInt(30) - 15;
        } while (b == 0);
        i = r.nextInt(action.length);
        switch (i) {
            case 1:
                x = a - b;
                break;
            case 2:
                x = a * b;
                break;
            case 3:
                x = a * b;
                int temp;
                temp = a;
                a = x;
                x = temp;
                break;
            default:
                x = a + b;
                break;
        }
        return new Question(a + " " + action[i] + " " + b + " = ", "" + x);
    }
}
