package com.example.andibag.domain.comment.service;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.comment.domain.repository.CommentRepository;
import com.example.andibag.domain.comment.exception.CommentNotFoundException;
import com.example.andibag.domain.comment.present.dto.request.CommentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentUpdateService {
    private final CommentRepository commentRepository;

    @Transactional
    public void commentUpdate(CommentUpdateRequest request, Long id) {
        Comment comment = commentRepository.findCommentById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        comment.updateComment(request.getContent());
    }
}
