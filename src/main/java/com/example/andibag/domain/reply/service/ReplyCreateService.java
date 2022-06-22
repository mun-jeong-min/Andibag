package com.example.andibag.domain.reply.service;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.comment.facade.CommentFacade;
import com.example.andibag.domain.reply.domain.Reply;
import com.example.andibag.domain.reply.domain.repository.ReplyRepository;
import com.example.andibag.domain.reply.present.dto.request.ReplyCreateRequest;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyCreateService {
    private final ReplyRepository replyRepository;
    private final UserFacade userFacade;
    private final CommentFacade commentFacade;

    public void replyCreate(ReplyCreateRequest request, Long commentId) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getCommentById(commentId);

        replyRepository.save(
                Reply.builder()
                        .content(request.getContent())
                        .user(user)
                        .comment(comment)
                        .build()
        );
    }
}
