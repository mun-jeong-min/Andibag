package com.example.andibag.domain.comment.service;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.comment.domain.repository.CommentRepository;
import com.example.andibag.domain.comment.exception.CommentNotFoundException;
import com.example.andibag.domain.reply.domain.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentDeleteService {
    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public void commentDelete(Long id) {
        Comment comment = commentRepository.findCommentById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        replyRepository.deleteAllByComment(comment);
        commentRepository.delete(comment);
    }
}
