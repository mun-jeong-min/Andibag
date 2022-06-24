package com.example.andibag.domain.comment.domain.repository;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.reply.domain.Reply;

import java.util.List;

public interface CommentCustom {
    List<Comment> getCommentById(Long id);
    List<Reply> getReplyById(Long id);
}
