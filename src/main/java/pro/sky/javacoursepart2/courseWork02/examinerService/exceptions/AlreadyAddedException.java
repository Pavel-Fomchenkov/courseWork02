package pro.sky.javacoursepart2.courseWork02.examinerService.exceptions;

public class AlreadyAddedException extends IllegalArgumentException {
    public AlreadyAddedException(String s) {
        super(s);
        System.out.println(s);
    }

}
