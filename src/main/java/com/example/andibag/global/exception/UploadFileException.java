package com.example.andibag.global.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class UploadFileException extends ProjectException {
    public static final UploadFileException EXCEPTION =
            new UploadFileException();

    public UploadFileException() {
        super(ErrorCode.UPLOAD_FILE_FAILED);
    }
}
