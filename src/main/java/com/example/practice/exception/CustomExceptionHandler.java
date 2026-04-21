package com.example.practice.exception;

import com.example.practice.record.EmployeeRecord;
import com.example.practice.record.Response;
import com.mongodb.MongoWriteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<Response<EmployeeRecord>> handleDuplicateEmpId(MongoWriteException exception){
        String msg = exception.getError().getMessage();
        Response<EmployeeRecord> response =  new Response<>(null, false, HttpStatus.BAD_REQUEST.value(), msg, LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Map<String, String>>> handleInvalidInputException(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        Response<Map<String, String>> response =  new Response<>(null, false, HttpStatus.BAD_REQUEST.value(), errors.toString(), LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }
}
