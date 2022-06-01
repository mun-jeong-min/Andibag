package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.domain.Friend;
import com.example.andibag.domain.friend.domain.repository.FriendRepository;
import com.example.andibag.domain.friend.exception.PhoneMismatchException;
import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FriendAddService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;

    @Transactional
    public void friendAdd(FriendAddRequest request) {
        User user = userRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> PhoneMismatchException.EXCEPTION);

        friendRepository.save(
                Friend.builder()
                        .user(user)
                        .build()
        );
    }
}
