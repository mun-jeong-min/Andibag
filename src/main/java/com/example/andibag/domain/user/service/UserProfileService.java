package com.example.andibag.domain.user.service;

import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import com.example.andibag.domain.user.present.dto.response.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserProfileService {
    private final UserRepository userRepository;

    public UserProfileResponse userProfile(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return UserProfileResponse.builder()
                .nickname(user.getNickname())
                .imageUrl(user.getImageUrl())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}