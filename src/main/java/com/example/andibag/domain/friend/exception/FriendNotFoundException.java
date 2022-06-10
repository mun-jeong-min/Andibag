package com.example.andibag.domain.friend.exception;

import com.example.andibag.domain.friend.domain.Friend;
import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class FriendNotFoundException extends ProjectException {
    public static final FriendNotFoundException EXCEPTION =
            new FriendNotFoundException();

    public FriendNotFoundException() {
        super(ErrorCode.FRIEND_NOT_FOUND);
    }
}
