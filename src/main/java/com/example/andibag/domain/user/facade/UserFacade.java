package com.example.andibag.domain.user.facade;

import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {

        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User findByNickName(String nickName) {
        return userRepository.findByNickname(nickName)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
