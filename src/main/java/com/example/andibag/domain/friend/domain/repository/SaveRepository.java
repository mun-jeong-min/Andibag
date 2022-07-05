package com.example.andibag.domain.friend.domain.repository;

import com.example.andibag.domain.friend.domain.Save;
import com.example.andibag.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SaveRepository extends CrudRepository<Save, Long> {
    List<Save> findSavesByUser(User user);
    Optional<Save> findById(Long id);
    Optional<Save> findSaveByMemoFriend(User user);
    List<Save> deleteSavesByUser(User user);
}
