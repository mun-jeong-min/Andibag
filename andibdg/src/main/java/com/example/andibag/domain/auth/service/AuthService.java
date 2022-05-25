package com.example.andibag.domain.auth.service;

import com.example.andibag.domain.auth.domain.RefreshToken;
import com.example.andibag.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.andibag.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.andibag.domain.auth.present.dto.UserRefreshTokenResponse;
import com.example.andibag.global.security.jwt.JwtProperties;
import com.example.andibag.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public UserRefreshTokenResponse execute(String refreshToken) {
        RefreshToken refreshTokenOne = refreshTokenRepository.findByToken(jwtTokenProvider.parseToken(refreshToken))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(refreshTokenOne.getAccountId());
        String accessToken = jwtTokenProvider.generateAccessToken(refreshTokenOne.getAccountId());

        refreshTokenOne.updateToken(newRefreshToken);

        return UserRefreshTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}
