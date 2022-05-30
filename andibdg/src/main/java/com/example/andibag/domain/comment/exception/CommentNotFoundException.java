package com.example.andibag.domain.comment.exception;

import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;

public class CommentNotFoundException extends ProjectException {
    public static final CommentNotFoundException EXCEPTION =
            new CommentNotFoundException();

    public CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }
}
