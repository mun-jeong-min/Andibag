package com.example.andibag.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProjectException extends RuntimeException {
    private final ErrorCode errorCode;
}
