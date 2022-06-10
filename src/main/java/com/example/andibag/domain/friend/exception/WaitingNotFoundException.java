package com.example.andibag.domain.friend.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class WaitingNotFoundException extends ProjectException {
    public static final WaitingNotFoundException EXCEPTION =
            new WaitingNotFoundException();

    public WaitingNotFoundException() {
        super(ErrorCode.WAITING_NOT_FOUND);
    }
}
