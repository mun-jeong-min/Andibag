package com.example.andibag.domain.chat.present.dto.response;

import com.example.andibag.domain.chat.domain.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class EnterRoomResponse {
    private String id;
    private Set<Message> messages;
}
