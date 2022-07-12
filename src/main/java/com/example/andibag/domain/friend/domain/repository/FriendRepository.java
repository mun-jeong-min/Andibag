package com.example.andibag.domain.friend.domain.repository;

import com.example.andibag.domain.friend.domain.Friend;
import com.example.andibag.domain.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    List<Friend> findAllByUser(User user);
    List<Friend> findFriendsByUser(User user);
    Optional<Friend> findFriendByUserAndUserFriend(User user, User userFriend);
    Optional<Friend> findFriendByUser(User user);
}
