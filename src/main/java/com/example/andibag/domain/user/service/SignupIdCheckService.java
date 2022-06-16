package com.example.andibag.domain.user.service;

import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserExistException;
import com.example.andibag.domain.user.present.dto.request.IdCheckRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignupIdCheckService {
    private final UserRepository userRepository;

    public void idCheck(IdCheckRequest request) {
        if(userRepository.findByAccountId(request.getAccountId()).isPresent())
            throw UserExistException.EXCEPTION;
    }
}