package com.example.andibag.domain.comment.service;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.comment.domain.repository.CommentRepository;
import com.example.andibag.domain.comment.present.dto.request.CommentCreateRequest;
import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.notice.facade.NoticeFacade;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentCreateService {
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final NoticeFacade noticeFacade;

    public void commentCreate(Long noticeId, CommentCreateRequest request) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.getNoticeById(noticeId);

        commentRepository.save(Comment.builder()
                .user(user)
                .notice(notice)
                .content(request.getContent())
                .isMine(true)
                .build());
    }
}
