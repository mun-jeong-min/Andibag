package com.example.andibag.domain.user.present;

import com.example.andibag.domain.user.present.dto.request.SignInRequest;
import com.example.andibag.domain.user.present.dto.request.SignUpRequest;
import com.example.andibag.domain.user.present.dto.response.TokenResponse;
import com.example.andibag.domain.user.service.UserSignInService;
import com.example.andibag.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;
    
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid SignUpRequest request) {
        userSignUpService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest request) {
        return userSignInService.signIn(request);
    }
}
