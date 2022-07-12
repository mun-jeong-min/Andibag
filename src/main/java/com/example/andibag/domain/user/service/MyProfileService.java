package com.example.andibag.domain.user.service;

import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import com.example.andibag.domain.user.facade.UserFacade;
import com.example.andibag.domain.user.present.dto.request.UpdateProfileRequest;
import com.example.andibag.domain.user.present.dto.response.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MyProfileService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    public UserProfileResponse myProfile() {
        User user = userFacade.getCurrentUser();

        return UserProfileResponse.builder()
                .nickname(user.getNickname())
                .imageUrl(user.getImageUrl())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    @Transactional
    public void patchProfile(UpdateProfileRequest request) {
        User user = userFacade.getCurrentUser();
        User find = userRepository.findById(user.getId())
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        find.updateUser(request.getNickname(), request.getImageUrl(), request.getPhoneNumber());
    }
}
