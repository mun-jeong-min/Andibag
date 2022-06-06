package com.example.andibag.domain.user.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserListResponse {
    private final List<UserResponse> userList;
}
