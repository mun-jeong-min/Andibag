package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.domain.Friend;
import com.example.andibag.domain.friend.domain.repository.FriendRepository;
import com.example.andibag.domain.friend.exception.FriendNotFoundException;
import com.example.andibag.domain.friend.exception.PhoneMismatchException;
import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FriendAddService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void AddFriend(FriendAddRequest request) {
        User user = userFacade.getCurrentUser();

        User friend = userRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> FriendNotFoundException.EXCEPTION);
        
        if (user.getPhoneNumber() == friend.getPhoneNumber()) {
            throw PhoneMismatchException.EXCEPTION;
        }

        friendRepository.save(
                Friend.builder()
                        .user(user)
                        .userFriend(friend)
                        .build()
        );

        friendRepository.save(
                Friend.builder()
                        .user(friend)
                        .userFriend(user)
                        .build()
        );
    }
}
