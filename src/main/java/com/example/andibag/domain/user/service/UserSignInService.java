package com.example.andibag.domain.user.service;

import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.PasswordMisMatch;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import com.example.andibag.domain.user.present.dto.request.SignInRequest;
import com.example.andibag.domain.user.present.dto.response.TokenResponse;
import com.example.andibag.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignInService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public TokenResponse signIn(SignInRequest request){
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatch.EXCEPTION;
        }

        String access = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refresh = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        return TokenResponse.builder()
                .accessToken(access)
                .refreshToken(refresh)
                .authority(user.getAuthority())
                .build();
    }
}
