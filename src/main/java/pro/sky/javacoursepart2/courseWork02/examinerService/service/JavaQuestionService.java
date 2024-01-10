package pro.sky.javacoursepart2.courseWork02.examinerService.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.javacoursepart2.courseWork02.examinerService.domain.Question;
import pro.sky.javacoursepart2.courseWork02.examinerService.domain.QuestionRepository;

import java.util.*;

@Service
@Qualifier("java")
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository repository;

    public JavaQuestionService(@Qualifier("java") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(String question, String answer) {
        return repository.remove(question, answer);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomInt = random.nextInt(repository.getAll().size());
        return repository.getAll().stream()
                .toList()
                .get(randomInt);
    }
}
