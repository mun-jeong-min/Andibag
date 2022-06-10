package com.example.andibag.domain.friend.service;

import com.example.andibag.domain.friend.domain.Waiting;
import com.example.andibag.domain.friend.domain.repository.WaitingRepository;
import com.example.andibag.domain.friend.exception.WaitingNotFoundException;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WaitingCheckService {
    private final WaitingRepository waitingRepository;
    private final UserFacade userFacade;

    @Transactional
    public void isTrue(Long id) {
        User user = userFacade.getCurrentUser();

        Waiting waiting = waitingRepository.findById(id)
                .orElseThrow(() -> WaitingNotFoundException.EXCEPTION);

        waiting.updateWaiting(true);
    }
    // 친구추가 요청을 보냈을때, fcm으로 친구요청을 보내서 확인,취소 버튼이 있는 알림창을 띄웠을때,
    // 확인을 누르면 patch요청을 보내서 boolean을 true
    //로 바꾸고 friend에 저장함.
    // 만약 취소 버튼 누르면
    // delete 요청을 보내서
    // waiting 에서도 지움

    @Transactional
    public void isFalse(Long id) {
        Waiting waiting = waitingRepository.findById(id)
                .orElseThrow(() -> WaitingNotFoundException.EXCEPTION);

        waitingRepository.delete(waiting);
    }
}
