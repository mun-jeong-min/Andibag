package com.example.andibag.domain.friend.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FriendAllResponse {
    private final List<FriendResponse> friendList;
}
