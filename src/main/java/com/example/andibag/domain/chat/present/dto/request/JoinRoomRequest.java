package com.example.andibag.domain.chat.present.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinRoomRequest {
    @JsonProperty("friend_id")
    private final Long friendId;
}
