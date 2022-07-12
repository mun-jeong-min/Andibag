package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.domain.Friend;
import com.example.andibag.domain.friend.domain.repository.FriendRepository;
import com.example.andibag.domain.friend.exception.FriendNotFoundException;
import com.example.andibag.domain.friend.exception.PhoneMismatchException;
import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.friend.present.dto.response.FriendResponse;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FriendSearchService {
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final UserFacade userFacade;

    public FriendResponse findUser(FriendAddRequest request) {
        User user = userRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> PhoneMismatchException.EXCEPTION);

        return FriendResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .imageUrl(user.getImageUrl())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    @Transactional
    public void deleteFriend(Long friend_id) {
        User user = userFacade.getCurrentUser();

        User userFriend = userRepository.findById(friend_id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Friend friend = friendRepository.findFriendByUserAndUserFriend(user, userFriend)
                .orElseThrow(() -> FriendNotFoundException.EXCEPTION);

        Friend friend1 = friendRepository.findFriendByUserAndUserFriend(userFriend, user)
                        .orElseThrow(() -> FriendNotFoundException.EXCEPTION);

        friendRepository.delete(friend);
        friendRepository.delete(friend1);
    }
}