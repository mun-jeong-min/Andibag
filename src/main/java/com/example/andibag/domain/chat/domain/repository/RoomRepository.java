package com.example.andibag.domain.chat.domain.repository;

import com.example.andibag.domain.chat.domain.Room;
import com.example.andibag.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findRoomsByHeadUser(User user);
}
