package com.example.andibag.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),

    USER_EXISTS(409, "USER-409-1", "User Exists");

    private final int status;
    private final String code;
    private final String message;
}
