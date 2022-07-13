package com.example.andibag.domain.user.present;

import com.example.andibag.domain.user.present.dto.request.IdCheckRequest;
import com.example.andibag.domain.user.present.dto.request.SignInRequest;
import com.example.andibag.domain.user.present.dto.request.SignUpRequest;
import com.example.andibag.domain.user.present.dto.request.UpdateProfileRequest;
import com.example.andibag.domain.user.present.dto.response.TokenResponse;
import com.example.andibag.domain.user.present.dto.response.UserListResponse;
import com.example.andibag.domain.user.present.dto.response.UserProfileResponse;
import com.example.andibag.domain.user.service.*;
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
    private final ProfileListService profileListService;
    private final UserProfileService userProfileService;
    private final SignupIdCheckService signupIdCheckService;
    private final MyProfileService myProfileService;
    
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid SignUpRequest request) {
        userSignUpService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest request) {
        return userSignInService.signIn(request);
    }

    @GetMapping
    public UserListResponse profileList() {
        return profileListService.userList();
    }

    @GetMapping("/my")
    public UserProfileResponse myProfile() {
        return myProfileService.myProfile();
    }

    @PatchMapping("/my")
    public void patchProfile(@RequestBody @Valid UpdateProfileRequest request) {
        myProfileService.patchProfile(request);
    }

    @GetMapping("/{id}")
    public UserProfileResponse userProfile(@PathVariable("id") Long id) {
        return userProfileService.userProfile(id);
    }

    @PostMapping("/signup/check")
    public void idCheck(@RequestBody @Valid IdCheckRequest request) {
        signupIdCheckService.idCheck(request);
    }
}