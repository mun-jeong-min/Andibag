package com.example.andibag.domain.auth.present;

import com.example.andibag.domain.auth.present.dto.UserRefreshTokenResponse;
import com.example.andibag.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PutMapping
    public UserRefreshTokenResponse reissue(@RequestHeader("Refresh-Token") String refreshToken) {
        return authService.reissue(refreshToken);
    }
}