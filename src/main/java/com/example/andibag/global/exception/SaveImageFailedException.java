package com.example.andibag.global.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class SaveImageFailedException extends ProjectException {
    public static final SaveImageFailedException EXCEPTION =
            new SaveImageFailedException();

    public SaveImageFailedException(){
        super(ErrorCode.SAVE_IMAGE_FAILED);
    }
}
