package com.example.andibag.domain.comment.service;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.comment.domain.repository.CommentRepository;
import com.example.andibag.domain.comment.present.dto.request.CommentCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentCreateService {
    private final CommentRepository commentRepository;

    public void commentCreate(CommentCreateRequest request) {
        commentRepository.save(Comment.builder()
                .content(request.getContent())
                .build());
    }
}
