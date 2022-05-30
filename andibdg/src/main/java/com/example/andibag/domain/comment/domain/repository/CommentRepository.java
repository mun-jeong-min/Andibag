package com.example.andibag.domain.comment.domain.repository;

import com.example.andibag.domain.comment.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    Optional<Comment> findCommentById(Long id);
}
