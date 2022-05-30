package com.example.andibag.domain.notice.service;

import com.example.andibag.domain.notice.domain.repository.NoticeRepository;
import com.example.andibag.domain.notice.present.dto.response.NoticeAllReadResponse;
import com.example.andibag.domain.notice.present.dto.response.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeAllReadService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public NoticeAllReadResponse noticeAllRead() {
        List<NoticeResponse> noticeList = noticeRepository.findAll()
                .stream().map(notice -> new NoticeResponse(notice.getTitle(), notice.getContent(), notice.getCreateTime()))
                .collect(Collectors.toList());

        return new NoticeAllReadResponse(noticeList);
    }
}
