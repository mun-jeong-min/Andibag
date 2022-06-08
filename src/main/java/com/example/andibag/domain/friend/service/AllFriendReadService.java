package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.domain.repository.FriendRepository;
import com.example.andibag.domain.friend.present.dto.response.FriendAllResponse;
import com.example.andibag.domain.friend.present.dto.response.FriendResponse;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.facade.UserFacade;
import com.example.andibag.domain.user.present.dto.response.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AllFriendReadService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public FriendAllResponse getAllFriend() {
        User user = userFacade.getCurrentUser();

        List<FriendResponse> list = friendRepository.findAllByUser_id(user.getId())
                .stream().map(friend -> new FriendResponse(friend.getUser().getNickname(), friend.getUser().getPhoneNumber()))
                .collect(Collectors.toList());

        return new FriendAllResponse(list);
    }
}
