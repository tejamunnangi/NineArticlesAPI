package com.nine.publishing.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nine.publishing.service.exception.ArticleInvalidException;

@ControllerAdvice
public class ArticleRestControllerExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
    	e = new RuntimeException("An Exception has occurred. Sorry for the inconvenience. We will try to resolve it soon");
        return error(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }
    @ExceptionHandler({ArticleNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(ArticleNotFoundException e) {
        return error(HttpStatus.NOT_FOUND, e);
    }
    @ExceptionHandler({ArticleInvalidException.class})
    public ResponseEntity<String> handleInvalidException(ArticleInvalidException e) {
        return error(HttpStatus.UNPROCESSABLE_ENTITY, e);
    }
    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
