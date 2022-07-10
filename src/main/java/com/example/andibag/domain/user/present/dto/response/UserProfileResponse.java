package com.example.andibag.domain.user.present.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserProfileResponse {
    private final String nickname;
    private final String phoneNumber;
    private final String imageUrl;
}
