package com.example.andibag.domain.memo.present.dto.response;

import com.example.andibag.domain.friend.present.dto.response.FriendResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FriendMemoResponse {
    private final List<FriendResponse> saveList;
}
