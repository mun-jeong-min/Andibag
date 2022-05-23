package com.example.andibag.global.error;

import com.example.andibag.global.error.exception.ProjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<ErrorResponse> handleException(ProjectException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getErrorCode().getMessage()), HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                new ErrorResponse(e.getBindingResult().getAllErrors().get(0).getDefaultMessage()), HttpStatus.BAD_REQUEST
        );
    }
}
