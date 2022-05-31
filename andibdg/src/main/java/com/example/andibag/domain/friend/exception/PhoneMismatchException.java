package com.example.andibag.domain.friend.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class PhoneMismatchException extends ProjectException {
    public static final PhoneMismatchException EXCEPTION =
            new PhoneMismatchException();

    public PhoneMismatchException() {
        super(ErrorCode.PHONE_MISMATCH);
    }
}
