package com.example.andibag.domain.notice.service;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.comment.domain.repository.CommentRepository;
import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.notice.domain.repository.NoticeRepository;
import com.example.andibag.domain.notice.exception.NoticeNotFoundException;
import com.example.andibag.domain.notice.present.dto.response.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NoticeOneReadService {
    private final NoticeRepository noticeRepository;
    private final CommentRepository commentRepository;

    public NoticeResponse noticeOneRead(Long id) {
        Notice notice = noticeRepository.findNoticeById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        return NoticeResponse.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .createAt(notice.getCreateTime())
                .modifyAt(notice.getModifyTime())
                .build();
    }
}
