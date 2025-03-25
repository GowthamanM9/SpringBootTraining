package com.training.exception;

import com.training.util.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(BookNotExistException.class)
    public ResponseEntity<ResponseMessage> handle(BookNotExistException e) {
        return ResponseEntity.status(400).body(new ResponseMessage(e.getMessage()));
    }

    @ExceptionHandler(BookExistsException.class)
    public ResponseEntity<ResponseMessage> handle(BookExistsException e) {
        return ResponseEntity.status(400).body(new ResponseMessage(e.getMessage()));
    }
}
