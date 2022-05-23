package com.example.andibag.domain.user.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class UserNotFoundException extends ProjectException {
    public static final UserNotFoundException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
