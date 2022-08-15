package com.example.andibag.domain.chat.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RoomResponse {
    private List<BasicRoomResponse> basicRoomResponses;
}
