package com.example.andibag.domain.user.domain.repository;

import com.example.andibag.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByAccountId(String accountId);
    Optional<User> findById(Long id);
    List<User> findAll();
}
