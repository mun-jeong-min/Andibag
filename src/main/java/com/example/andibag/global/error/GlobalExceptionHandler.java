package com.example.andibag.global.error;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<ErrorResponse> handleException(ProjectException e) {
        ErrorCode errorCode = e.getErrorCode();

        return new ResponseEntity<>(
                new ErrorResponse(errorCode.getStatus(), errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                new ErrorResponse(400, e.getBindingResult().getAllErrors().get(0).getDefaultMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
