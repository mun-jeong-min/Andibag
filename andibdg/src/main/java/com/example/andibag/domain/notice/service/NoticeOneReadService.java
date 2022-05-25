package com.example.andibag.domain.notice.service;

import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.notice.domain.repository.NoticeRepository;
import com.example.andibag.domain.notice.present.dto.response.NoticeOneReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NoticeOneReadService {
    private final NoticeRepository noticeRepository;

    public NoticeOneReadResponse noticeOneRead(Long id) {
        Notice notice = noticeRepository.findNoticeById(id);

        return NoticeOneReadResponse.builder()
                .title(notice.getTitle())
                .content(notice.getContent())
                .build();
    }
}
