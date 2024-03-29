package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.domain.Friend;
import com.example.andibag.domain.friend.domain.repository.FriendRepository;
import com.example.andibag.domain.friend.exception.FriendNotFoundException;
import com.example.andibag.domain.friend.present.dto.request.FriendSearchRequest;
import com.example.andibag.domain.friend.present.dto.response.FriendResponse;
import com.example.andibag.domain.memo.domain.Memo;
import com.example.andibag.domain.memo.domain.repository.MemoRepository;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FriendSearchMemoService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;
    private final MemoRepository saveRepository;
    private final UserFacade userFacade;

    public FriendResponse friendMemo(FriendSearchRequest request) {
        User currentUser = userFacade.getCurrentUser();

        User user = userFacade.findByNickName(request.getNickname());

        Friend friend = friendRepository.findFriendByUser(user)
                .orElseThrow(() -> FriendNotFoundException.EXCEPTION);

        saveRepository.save(
                Memo.builder()
                        .user(currentUser)
                        .memoFriend(friend.getUser())
                        .build()
        );

        return FriendResponse.builder()
                .id(friend.getUser().getId())
                .nickname(friend.getUser().getNickname())
                .imageUrl(friend.getUser().getImageUrl())
                .phoneNumber(friend.getUser().getPhoneNumber())
                .build();
    }
}
