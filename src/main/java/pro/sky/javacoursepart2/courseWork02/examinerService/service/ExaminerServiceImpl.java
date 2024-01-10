package pro.sky.javacoursepart2.courseWork02.examinerService.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.javacoursepart2.courseWork02.examinerService.domain.Question;
import pro.sky.javacoursepart2.courseWork02.examinerService.exceptions.WrongAmountException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Collection<Question> examQuestionList;
    private List<QuestionService> questionServices = new ArrayList<>();

    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaQuestionService, @Qualifier("math") QuestionService mathQuestionService) {
        this.questionServices.add(javaQuestionService);
        this.questionServices.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Random random = new Random();
        int topic;
        Question question;
        examQuestionList = new ArrayList<>();
        if (amount <= 0) {
            throw new WrongAmountException("Количество вопросов " + amount + ", должно быть больше 0");
        }
        while (examQuestionList.size() < amount) {
            topic = random.nextInt(questionServices.size());
            question = questionServices.get(topic).getRandomQuestion();
            if (!examQuestionList.contains(question)) {
                examQuestionList.add(question);
            }
        }
        return examQuestionList;
    }
}
