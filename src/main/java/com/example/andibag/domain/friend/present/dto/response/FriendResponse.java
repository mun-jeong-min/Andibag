package com.example.andibag.domain.friend.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FriendResponse {
    private final String nickname;
    private final String phoneNumber;
}
