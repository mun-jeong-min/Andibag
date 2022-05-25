package com.example.andibag.domain.auth.present;

import com.example.andibag.domain.auth.present.dto.UserRefreshTokenResponse;
import com.example.andibag.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping
    public UserRefreshTokenResponse execute(@RequestHeader("refresh-token") String refreshToken) {
        return authService.execute(refreshToken);
    }
}
