package com.example.andibag.domain.auth.service;

import com.example.andibag.domain.auth.domain.RefreshToken;
import com.example.andibag.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.andibag.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.andibag.domain.auth.present.dto.UserRefreshTokenResponse;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.facade.UserFacade;
import com.example.andibag.global.enums.Authority;
import com.example.andibag.global.exception.InvalidJwtException;
import com.example.andibag.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserFacade userFacade;

    @Transactional
    public UserRefreshTokenResponse reissue(String refreshToken) {
        User user = userFacade.getCurrentUser();

        if (!jwtTokenProvider.getTokenBody(refreshToken).get("typ").equals("refresh"))
            throw InvalidJwtException.EXCEPTION;

        RefreshToken refreshTokenOne = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(refreshTokenOne.getAccountId());
        refreshTokenOne.updateToken(newRefreshToken);

        String accessToken = jwtTokenProvider.generateAccessToken(refreshTokenOne.getAccountId());

        return UserRefreshTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(newRefreshToken)
                .authority(user.getAuthority())
                .build();
    }
}
