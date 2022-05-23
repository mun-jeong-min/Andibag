package com.example.andibag.domain.user.present;

import com.example.andibag.domain.user.present.dto.request.SignUpRequest;
import com.example.andibag.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private UserSignUpService userSignInService;

    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignUpRequest signUpRequest) {
        userSignInService.signup(signUpRequest);
    }
}
