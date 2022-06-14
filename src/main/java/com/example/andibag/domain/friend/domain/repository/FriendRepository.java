package com.example.andibag.domain.friend.domain.repository;

import com.example.andibag.domain.friend.domain.Friend;
import com.example.andibag.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    Optional<Friend> findAllByUserId(Long userId);
}
