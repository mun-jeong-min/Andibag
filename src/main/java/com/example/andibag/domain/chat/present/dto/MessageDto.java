package com.example.andibag.domain.chat.present.dto;

import com.example.andibag.domain.chat.domain.types.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MessageDto {
    private MessageType messageType;
    private String roomId;
    private String writer;
    private String message;
}