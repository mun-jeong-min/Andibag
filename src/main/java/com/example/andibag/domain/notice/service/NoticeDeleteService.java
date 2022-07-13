package com.example.andibag.domain.notice.service;

import com.example.andibag.domain.comment.domain.repository.CommentRepository;
import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.notice.domain.repository.NoticeRepository;
import com.example.andibag.domain.notice.exception.NoticeNotFoundException;
import com.example.andibag.domain.reply.domain.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class NoticeDeleteService {
    private final NoticeRepository noticeRepository;
    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public void noticeDelete(Long id) {
        Notice notice = noticeRepository.findNoticeById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);


        replyRepository.deleteAllByNotice(notice);
        commentRepository.deleteAllByNotice(notice);
        noticeRepository.delete(notice);
    }
}
