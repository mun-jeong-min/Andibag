package com.example.andibag.domain.friend.domain.repository;

import com.example.andibag.domain.friend.domain.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    Optional<Friend> findAllByUser_id(Long id);
}
