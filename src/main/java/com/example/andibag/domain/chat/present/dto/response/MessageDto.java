package com.example.andibag.domain.chat.present.dto.response;

import com.example.andibag.domain.chat.domain.types.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MessageDto {
    private final String roomId;

    private final Long messageId;

    private final String name;

    private final String content;

    private final LocalDateTime time;

    private final MessageType type;

}