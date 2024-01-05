package pro.sky.javacoursepart2.courseWork02.examinerService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongAmountException extends IndexOutOfBoundsException {
    public WrongAmountException(String s) {
        super(s);
        System.out.println(s);
    }
}
