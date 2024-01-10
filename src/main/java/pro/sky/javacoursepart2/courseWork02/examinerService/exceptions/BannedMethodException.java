package pro.sky.javacoursepart2.courseWork02.examinerService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class BannedMethodException extends RuntimeException {
    public BannedMethodException(String message) {
        super(message);
        System.out.println(message);
    }
}

