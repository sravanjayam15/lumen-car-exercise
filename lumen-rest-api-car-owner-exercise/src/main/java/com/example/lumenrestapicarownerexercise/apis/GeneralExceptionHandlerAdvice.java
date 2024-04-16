package com.example.lumenrestapicarownerexercise.apis;

import com.example.lumenrestapicarownerexercise.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GeneralExceptionHandlerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
        // logging
        System.out.println(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException e) {
        // logging
        System.out.println(e.getMessage());
        Map<String, String> errors = Map.of("error", e.getMessage());
        return ResponseEntity.status(404).body(errors);
    }
}
