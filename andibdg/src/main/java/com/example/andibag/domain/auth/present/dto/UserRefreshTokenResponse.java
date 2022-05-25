package com.example.andibag.domain.auth.present.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRefreshTokenResponse {
    private final String accessToken;
    private final String refreshToken;
}
