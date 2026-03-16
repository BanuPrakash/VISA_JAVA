package com.visa.ecomapp.api;

import com.visa.ecomapp.service.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        Map<String, String> body  = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", "404, Not Found");
        body.put("error", ex.getMessage());

        return new  ResponseEntity(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> body  = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(exception -> exception.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors", errors);

        return new  ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }
}


