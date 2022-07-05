package com.example.andibag.domain.friend.present.dto.response;

import com.example.andibag.domain.friend.domain.Save;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FriendMemoResponse {
    private final List<FriendResponse> saveList;
}
