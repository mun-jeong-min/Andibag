package com.example.andibag.domain.chat.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class RoomNotFoundException extends ProjectException {
    public static final RoomNotFoundException EXCEPTION =
            new RoomNotFoundException();

    public RoomNotFoundException() {
        super(ErrorCode.ROOM_NOT_FOUND);
    }
}
