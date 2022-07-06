package com.example.andibag.domain.memo.domain.repository;

import com.example.andibag.domain.memo.domain.Memo;
import com.example.andibag.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MemoRepository extends CrudRepository<Memo, Long> {
    List<Memo> findMemosByUser(User user);

    Optional<Memo> findById(Long id);

    Optional<Memo> findMemoByMemoFriend(User user);

    List<Memo> deleteByUser(User user);
}
