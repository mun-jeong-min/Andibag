package com.example.andibag.domain.chat.domain.repository;

import com.example.andibag.domain.chat.domain.Member;
import com.example.andibag.domain.chat.domain.Room;
import com.example.andibag.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByUserAndRoom(User user, Room room);
}