package pro.sky.javacoursepart2.courseWork02.examinerService.service;

import pro.sky.javacoursepart2.courseWork02.examinerService.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
