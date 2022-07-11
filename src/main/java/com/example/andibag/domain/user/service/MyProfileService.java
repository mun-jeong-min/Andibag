package com.example.andibag.domain.user.service;

import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.facade.UserFacade;
import com.example.andibag.domain.user.present.dto.response.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyProfileService {
    private final UserFacade userFacade;

    public UserProfileResponse myProfile() {
        User user = userFacade.getCurrentUser();

        return UserProfileResponse.builder()
                .nickname(user.getNickname())
                .imageUrl(user.getImageUrl())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
