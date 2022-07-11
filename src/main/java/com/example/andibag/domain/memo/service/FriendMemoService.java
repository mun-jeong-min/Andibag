package com.example.andibag.domain.memo.service;

import com.example.andibag.domain.friend.exception.FriendNotFoundException;
import com.example.andibag.domain.friend.present.dto.response.FriendResponse;
import com.example.andibag.domain.memo.domain.Memo;
import com.example.andibag.domain.memo.domain.repository.MemoRepository;
import com.example.andibag.domain.memo.present.dto.response.FriendMemoResponse;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FriendMemoService {
    private final MemoRepository memoRepository;
    private final UserFacade userFacade;

    public FriendMemoResponse friendMemo() {
        User user = userFacade.getCurrentUser();

        List<FriendResponse> friendResponses = memoRepository.findMemosByUser(user)
                .stream()
                .map(save -> new FriendResponse(
                        save.getMemoFriend().getId(),
                        save.getMemoFriend().getNickname(),
                        save.getMemoFriend().getImageUrl(),
                        save.getMemoFriend().getPhoneNumber()
                )).collect(Collectors.toList());

        return new FriendMemoResponse(friendResponses);
    }

    @Transactional
    public void deleteMemo(Long id) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> FriendNotFoundException.EXCEPTION);

        memoRepository.delete(memo);
    }

    @Transactional
    public void deleteAll() {
        User user = userFacade.getCurrentUser();

        memoRepository.deleteByUser(user);
    }
}