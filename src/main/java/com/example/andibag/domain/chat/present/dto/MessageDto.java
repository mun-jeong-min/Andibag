package com.example.andibag.domain.chat.present.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MessageDto {
    private String roomId;
    private String message;
}