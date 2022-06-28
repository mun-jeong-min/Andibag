package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.domain.Friend;
import com.example.andibag.domain.friend.domain.repository.FriendRepository;
import com.example.andibag.domain.friend.exception.FriendNotFoundException;
import com.example.andibag.domain.friend.present.dto.request.FriendSearchRequest;
import com.example.andibag.domain.friend.present.dto.response.FriendResponse;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FriendSearchMemoService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;

    public FriendResponse friendMemo(FriendSearchRequest request) {
        User user = userRepository.findByNickname(request.getNickname())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Friend friend = friendRepository.findFriendByUser(user)
                .orElseThrow(() -> FriendNotFoundException.EXCEPTION);

        return FriendResponse.builder()
                .id(friend.getUserFriend().getId())
                .nickname(friend.getUserFriend().getNickname())
                .phoneNumber(friend.getUserFriend().getPhoneNumber())
                .build();
    }
}
