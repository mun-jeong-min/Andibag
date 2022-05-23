package com.example.andibag.domain.user.present;

import com.example.andibag.domain.user.service.UserSignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private UserSignInService userSignInService;
}
