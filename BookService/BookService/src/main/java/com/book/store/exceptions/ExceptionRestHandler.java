package com.book.store.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionRestHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleResourceNotFoundException(ResourceNotFoundException exception){
        return new ResponseEntity<>(new ExceptionDTO(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BookLimitExceededException.class)
    public ResponseEntity<ExceptionDTO> handleBookLimitExceededException(BookLimitExceededException exception){
        return new ResponseEntity<>(new ExceptionDTO(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
