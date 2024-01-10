package pro.sky.javacoursepart2.courseWork02.examinerService.domain;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pro.sky.javacoursepart2.courseWork02.examinerService.exceptions.AlreadyAddedException;
import pro.sky.javacoursepart2.courseWork02.examinerService.exceptions.QuestionNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Repository
@Qualifier("java")
public class JavaQuestionRepository implements QuestionRepository {
    private Collection<Question> repository = new ArrayList<>();

    @PostConstruct
    private void init() {
        add("Как объявить класс в коде?", "class MyClass {}");
        add("Для чего используется оператор 'new'?", "Для создания экземпляра класса.");
        add("Что означает ключевое слово 'extends'?", "Что данный класс наследуется от другого.");
        add("Что означает перегрузка (overload) метода в Java?", "Несколько методов с одинаковым названием, но разным набором параметров.");
        add("Что означает переопределение метода в Java (override)?", "Изменение поведения метода класса относительно родительского.");
        add(new Question("Чем отличаются 'static' метод класса от обычного метода?", "Обычный метод класса работает от объекта класса, а static-метод от всего класса."));
        add(new Question("Как вызвать static-метод внутри обычного?", "Можно, ничего дополнительно делать не надо."));
        add(new Question("Как вызвать обычный метод класса внутри static-метода?", "Никак, static-метод не работает с объектом класса."));
        add(new Question("Для чего необходимо ключевое слово 'this'?", "Это указатель на текущий объект класса внутри самого класса. Его можно опускать при вызове метода класса, но лучше этого не делать."));
        add(new Question("Что вернет метод, объявленный следующим образом: 'public static int getAmount()'?", "Вернет целочисленное значение."));
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        if (repository.contains(q)) {
            throw new AlreadyAddedException("Этот вопрос уже имеется в базе вопросов");
        }
        repository.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        if (repository.contains(question)) {
            throw new AlreadyAddedException("Этот вопрос уже имеется в базе вопросов");
        }
        repository.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question qToFind = new Question(question, answer);
        repository.stream()
                .filter(q -> q.equals(qToFind))
                .findAny()
                .map(q -> repository.remove(q))
                .orElseThrow(() -> new QuestionNotFoundException("Элемент не найден"));
        return qToFind;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(repository);
    }
}
