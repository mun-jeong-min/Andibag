package com.example.andibag.domain.user.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class UserExistException extends ProjectException {
    public static final UserExistException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXISTS);
    }
}
