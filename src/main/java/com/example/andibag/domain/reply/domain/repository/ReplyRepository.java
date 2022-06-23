package com.example.andibag.domain.reply.domain.repository;

import com.example.andibag.domain.reply.domain.Reply;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReplyRepository extends CrudRepository<Reply, Long> {
    Optional<Reply> findReplyById(Long id);
}
