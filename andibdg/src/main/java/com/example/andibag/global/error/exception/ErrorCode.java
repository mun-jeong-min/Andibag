package com.example.andibag.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_JWT(401, "JWT-401-1", "Invalid Jwt"),
    PASSWORD_MISMATCH(401,"user-401-1","Password Mismatch"),

    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),

    USER_EXISTS(409, "USER-409-1", "User Exists");

    private final int status;
    private final String code;
    private final String message;
}
