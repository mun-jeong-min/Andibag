package com.example.andibag.domain.user.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class PasswordMisMatch extends ProjectException {
    public static final PasswordMisMatch EXCEPTION =
            new PasswordMisMatch();

    public PasswordMisMatch() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
