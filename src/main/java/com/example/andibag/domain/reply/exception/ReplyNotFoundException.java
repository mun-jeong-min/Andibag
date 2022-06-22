package com.example.andibag.domain.reply.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class ReplyNotFoundException extends ProjectException {
    public static final ReplyNotFoundException EXCEPTION =
            new ReplyNotFoundException();

    public ReplyNotFoundException() {
        super(ErrorCode.REPLY_NOT_FOUND);
    }
}
