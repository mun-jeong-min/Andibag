package com.example.andibag.domain.comment.domain.repository;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.reply.domain.Reply;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.andibag.domain.comment.domain.QComment.comment;
import static com.example.andibag.domain.notice.domain.QNotice.notice;
import static com.example.andibag.domain.reply.domain.QReply.reply;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentCustom{
    private final JPAQueryFactory query;

    @Override
    public List<Comment> getCommentById(Long id) {
        return query.selectFrom(comment)
                .leftJoin(comment.notice, notice)
                .where(notice.id.eq(id))
                .fetch();
    }

    @Override
    public List<Reply> getReplyById(Long id) {
        return query.selectFrom(reply)
                .leftJoin(reply.comment, comment)
                .where(comment.id.eq(id))
                .fetch();
    }
}
