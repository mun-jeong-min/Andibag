package com.example.andibag.domain.comment.service;

import com.example.andibag.domain.comment.domain.repository.CommentRepository;
import com.example.andibag.domain.reply.domain.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentReadService {
    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;

    public 
}
