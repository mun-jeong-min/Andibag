package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.exception.PhoneMismatchException;
import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.friend.present.dto.response.FriendResponse;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FriendSearchService {
    private final UserRepository userRepository;

    public FriendResponse findUser(FriendAddRequest request) {
        User user = userRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> PhoneMismatchException.EXCEPTION);

        return FriendResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}