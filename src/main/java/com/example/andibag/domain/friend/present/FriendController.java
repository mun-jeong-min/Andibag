package com.example.andibag.domain.friend.present;

import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.friend.service.FriendAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/friend")
public class FriendController {
    private final FriendAddService friendAddService;

    @PostMapping
    public void friendAdd(@RequestBody @Valid FriendAddRequest request) {
        friendAddService.friendAdd(request);
    }
}
