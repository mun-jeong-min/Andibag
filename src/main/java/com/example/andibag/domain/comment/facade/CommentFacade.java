package com.example.andibag.domain.comment.facade;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.comment.domain.repository.CommentRepository;
import com.example.andibag.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {
    private final CommentRepository commentRepository;

    public Comment getCommentById(Long commentId) {
        return commentRepository.findCommentById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }
}
