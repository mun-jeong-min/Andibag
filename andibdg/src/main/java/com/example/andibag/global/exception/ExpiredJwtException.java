package com.example.andibag.global.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class ExpiredJwtException extends ProjectException {
    public static final ExpiredJwtException EXCEPTION =
            new ExpiredJwtException();

    public ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
