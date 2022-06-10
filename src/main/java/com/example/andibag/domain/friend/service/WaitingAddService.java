package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.domain.Waiting;
import com.example.andibag.domain.friend.domain.repository.WaitingRepository;
import com.example.andibag.domain.friend.exception.PhoneMismatchException;
import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WaitingAddService {
    private final WaitingRepository waitingRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void friendAdd(FriendAddRequest request) {
        User currentUser = userFacade.getCurrentUser();

        User userFriend = userRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> PhoneMismatchException.EXCEPTION);

        if(currentUser.getPhoneNumber().equals(userFriend.getPhoneNumber())) {
            throw PhoneMismatchException.EXCEPTION;
        }

        waitingRepository.save(
                Waiting.builder()
                        .user(currentUser)
                        .userFriend(userFriend)
                        .isChecked(false)
                        .build()
        );
    }
}
