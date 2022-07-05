package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.domain.Save;
import com.example.andibag.domain.friend.domain.repository.SaveRepository;
import com.example.andibag.domain.friend.exception.FriendNotFoundException;
import com.example.andibag.domain.friend.present.dto.response.FriendMemoResponse;
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
public class FriendMemoService {
    private final SaveRepository saveRepository;
    private final UserFacade userFacade;

    public FriendMemoResponse friendMemo() {
        User user = userFacade.getCurrentUser();

        List<FriendResponse> friendResponses = saveRepository.findSavesByUser(user)
                .stream()
                .map(save -> new FriendResponse(
                        save.getMemoFriend().getId(),
                        save.getMemoFriend().getNickname(),
                        save.getMemoFriend().getPhoneNumber()
                )).collect(Collectors.toList());

        return new FriendMemoResponse(friendResponses);
    }

    @Transactional
    public void deleteMemo(Long id) {
        Save save = saveRepository.findById(id)
                .orElseThrow(() -> FriendNotFoundException.EXCEPTION);

        saveRepository.delete(save);
    }

    @Transactional
    public void deleteAll() {
        User user = userFacade.getCurrentUser();

        saveRepository.deleteSavesByUser(user);
    }
}