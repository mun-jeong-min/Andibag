package com.example.andibag.domain.notice.service;

import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.notice.domain.repository.NoticeRepository;
import com.example.andibag.domain.notice.exception.NoticeNotFoundException;
import com.example.andibag.domain.notice.present.dto.reqeust.NoticeUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NoticeUpdateService {
    private final NoticeRepository noticeRepository;

    public void updateNotice(Long id, NoticeUpdateRequest request) {
        Notice notice = noticeRepository.findNoticeById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        notice.updateNotice(request.getTitle(), request.getContent());
    }
}
