package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.domain.repository.FriendRepository;
import com.example.andibag.domain.friend.present.dto.response.FriendAllResponse;
import com.example.andibag.domain.friend.present.dto.response.FriendResponse;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class AllFriendListService {
    private final FriendRepository friendRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public FriendAllResponse getAllFriend() {
        User user = userFacade.getCurrentUser();
        
        List<FriendResponse> list = friendRepository.findAllByUser(user)
                .stream()
                .map(friend -> new FriendResponse(friend.getUserFriend().getId(), friend.getUserFriend().getNickname(), friend.getUserFriend().getImageUrl(), friend.getUserFriend().getPhoneNumber()))
                .collect(Collectors.toList());

        return new FriendAllResponse(list);
    }
}
