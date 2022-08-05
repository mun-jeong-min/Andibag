package com.example.andibag.domain.chat.present.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
@AllArgsConstructor
public class MessageDto {
    private String roomId;
    private String writer;
    private String message;
}