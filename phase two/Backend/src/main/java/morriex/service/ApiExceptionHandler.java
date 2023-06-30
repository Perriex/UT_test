package morriex.service;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import morriex.exception.HttpException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            HttpException ex) {
        System.out.println("Exception Happend");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.valueOf(ex.getStatus()));
    }
}