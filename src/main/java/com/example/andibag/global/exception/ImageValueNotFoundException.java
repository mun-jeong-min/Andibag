package com.example.andibag.global.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class ImageValueNotFoundException extends ProjectException {
    public static final ImageValueNotFoundException EXCEPTION =
            new ImageValueNotFoundException();

    public ImageValueNotFoundException() {
        super(ErrorCode.IMAGE_VALUE_NOT_FOUND);
    }
}
