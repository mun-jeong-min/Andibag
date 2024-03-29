package com.example.andibag.domain.chat.domain.repository;

import com.example.andibag.domain.chat.domain.Room;
import com.example.andibag.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAllByHeadUser(User user);
    Optional<Room> findById(String id);
    Optional<Room> findByHeadUserAndFriend(User user, User friend);
}
