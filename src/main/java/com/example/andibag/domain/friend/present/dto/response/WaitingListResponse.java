package com.example.andibag.domain.friend.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class WaitingListResponse {
    private final List<FriendResponse> list;
}
