package com.example.andibag.domain.user.present.dto.response;

import com.example.andibag.global.enums.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final Authority authority;
}
