package com.example.andibag.domain.comment.service;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.comment.domain.repository.CommentRepository;
import com.example.andibag.domain.comment.present.dto.response.QueryReadResponse;
import com.example.andibag.domain.comment.present.dto.response.QueryResponse;
import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.notice.domain.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryReadAllService {
    private final CommentRepository commentRepository;

    public QueryResponse readAllComments(Long noticeId) {
        List<QueryReadResponse> comment = commentRepository.getCommentById(noticeId)
                .stream()
                .map(comment1 -> new QueryReadResponse(comment1.getUser().getNickname(), comment1.getContent(),
                        commentRepository.getReplyById(comment1.getId()
                        )))
                .collect(Collectors.toList());

        return new QueryResponse(comment);
    }
}
