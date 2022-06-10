package com.example.andibag.domain.friend.domain.repository;

import com.example.andibag.domain.friend.domain.Waiting;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WaitingRepository extends CrudRepository<Waiting, Long> {
    Optional<Waiting> findAllById(Long id);
}
