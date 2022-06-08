package com.example.andibag.domain.friend.present;

import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.friend.present.dto.response.FriendAllResponse;
import com.example.andibag.domain.friend.service.AllFriendReadService;
import com.example.andibag.domain.friend.service.FriendAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/friend")
public class FriendController {
    private final FriendAddService friendAddService;
    private final AllFriendReadService allFriendReadService;

    @PostMapping
    public void friendAdd(@RequestBody @Valid FriendAddRequest request) {
        friendAddService.friendAdd(request);
    }

    @GetMapping
    public FriendAllResponse getAllFriend() {
        return allFriendReadService.getAllFriend();
    }
}
