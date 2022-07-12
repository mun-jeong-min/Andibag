package com.example.andibag.domain.user.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateProfileRequest {
    private String nickname;
    private String imageUrl;
    private String phoneNumber;
}
