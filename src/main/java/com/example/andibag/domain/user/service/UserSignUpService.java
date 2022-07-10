package com.example.andibag.domain.user.service;

import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserExistException;
import com.example.andibag.domain.user.present.dto.request.SignUpRequest;
import com.example.andibag.global.enums.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignUpRequest request) {
        if(userRepository.findByAccountId(request.getAccountId()).isPresent())
            throw UserExistException.EXCEPTION;

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .nickname(request.getNickname())
                        .imageUrl(request.getImageUrl())
                        .phoneNumber(request.getPhoneNumber())
                        .authority(Authority.USER)
                        .build()
        );
    }
}
