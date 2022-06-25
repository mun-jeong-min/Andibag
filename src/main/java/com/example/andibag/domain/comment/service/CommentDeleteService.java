package com.example.andibag.domain.comment.service;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.comment.domain.repository.CommentRepository;
import com.example.andibag.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentDeleteService {
    private final CommentRepository commentRepository;

    @Transactional
    public void commentDelete(Long id) {
        Comment comment = commentRepository.findCommentById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        commentRepository.delete(comment);
    }
}