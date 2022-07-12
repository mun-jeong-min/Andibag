package com.example.andibag.domain.comment.domain.repository;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.reply.domain.Reply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long>, CommentCustom {
    Optional<Comment> findCommentById(Long id);
    List<Comment> findAllByNotice(Notice notice);
    List<Comment> deleteAllByNotice(Notice notice);
}
