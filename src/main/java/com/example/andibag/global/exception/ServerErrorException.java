package com.example.andibag.global.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class ServerErrorException extends ProjectException {

    public static final ServerErrorException EXCEPTION =
            new ServerErrorException();

    public ServerErrorException() {
        super(ErrorCode.SERVER_ERROR);
    }
}
