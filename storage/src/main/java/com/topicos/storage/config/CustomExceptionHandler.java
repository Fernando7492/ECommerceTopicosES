package com.topicos.storage.config;

import com.topicos.storage.create.exception.DuplicateRecordException;
import com.topicos.storage.create.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DuplicateRecordException.class)
    protected ResponseEntity<Object> handleDuplicateRecordException(DuplicateRecordException exception) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> error = new HashMap<>();

        error.put("type", "DuplicateRecord");
        error.put("message", exception.getMessage());
        response.put("error", error);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    protected ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException exception) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> error = new HashMap<>();

        error.put("type", "RecordNotFound");
        error.put("message", exception.getMessage());
        response.put("error", error);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
