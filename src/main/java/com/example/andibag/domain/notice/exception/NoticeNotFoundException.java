package com.example.andibag.domain.notice.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class NoticeNotFoundException extends ProjectException {
    public static final NoticeNotFoundException EXCEPTION =
            new NoticeNotFoundException();

    public NoticeNotFoundException() {
        super(ErrorCode.NOTICE_NOT_FOUND);
    }
}
