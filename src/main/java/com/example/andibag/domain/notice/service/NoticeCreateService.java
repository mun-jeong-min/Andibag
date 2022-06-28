package com.example.andibag.domain.notice.service;

import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.notice.domain.repository.NoticeRepository;
import com.example.andibag.domain.notice.domain.repository.type.NoticeCategory;
import com.example.andibag.domain.notice.present.dto.reqeust.NoticeCreateRequest;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class NoticeCreateService {
    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;

    @Transactional
    public void noticeCreate(NoticeCreateRequest request) {

        User user = userFacade.getCurrentUser();

        noticeRepository.save(
                Notice.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .user(user)
                        .noticeType(NoticeCategory.values()[new Random().nextInt(NoticeCategory.values().length)])
                        .isMine(true)
                        .build()
        );
    }
}
