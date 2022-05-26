package com.example.andibag.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_JWT(401, "JWT-401-1", "Invalid Jwt"),
    PASSWORD_MISMATCH(401,"auth-401-1","Password Mismatch"),
    EXPIRED_JWT(401, "jwt-401-2", "Expired Jwt"),


    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    REFRESH_NOT_FOUND(404, "jwt-404-1", "RefreshToken Not Found"),
    NOTICE_NOT_FOUND(404, "notice-404-1", "Notice Not Found"),

    USER_EXISTS(409, "USER-409-1", "User Exists");

    private final int status;
    private final String code;
    private final String message;
}
