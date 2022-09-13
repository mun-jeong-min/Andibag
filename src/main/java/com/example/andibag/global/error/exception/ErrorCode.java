package com.example.andibag.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    UPLOAD_FILE_FAILED(400, "AUTH-400-1", "Upload File Failed"),
    SAVE_IMAGE_FAILED(400, "COMMON-400-1", "Save Image Failed"),

    INVALID_JWT(401, "JWT-401-1", "Invalid Jwt"),
    PASSWORD_MISMATCH(401,"auth-401-1","Password Mismatch"),
    PHONE_MISMATCH(401, "user-401-1", "PhoneNumber Mismatch"),

    EXPIRED_JWT(401, "jwt-401-2", "Expired Jwt"),

    IMAGE_VALUE_NOT_FOUND(404, "COMMON-404-1", "Image Value Not Found"),
    ROOM_NOT_FOUND(404, "room-404-1", "Room Not Found"),
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    REFRESH_NOT_FOUND(404, "jwt-404-1", "RefreshToken Not Found"),
    NOTICE_NOT_FOUND(404, "notice-404-1", "Notice Not Found"),
    REPLY_NOT_FOUND(404, "reply-404-1", "Reply Not Found"),
    COMMENT_NOT_FOUND(404, "comment-404-1", "Comment Not Found"),
    FRIEND_NOT_FOUND(404, "friend-404-1", "Friend Not Found"),

    USER_EXISTS(409, "USER-409-1", "User Exists"),

    SERVER_ERROR(500, "server-500-1", "server error");

    private final int status;
    private final String code;
    private final String message;
}
