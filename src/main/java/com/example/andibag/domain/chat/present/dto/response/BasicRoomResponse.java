package com.example.andibag.domain.chat.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BasicRoomResponse {
    private String id;
    private String roomName;
}
