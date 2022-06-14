package com.example.andibag.domain.friend.present;

import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.friend.present.dto.response.FriendAllResponse;
import com.example.andibag.domain.friend.service.AllFriendListService;
import com.example.andibag.domain.friend.service.FriendAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/friend")
public class FriendController {
    private final FriendAddService friendAddService;
    private final AllFriendListService allFriendListService;

    @PostMapping
    public void addFriend(@RequestBody @Valid FriendAddRequest request) {
        friendAddService.AddFriend(request);
    }

    @GetMapping
    public FriendAllResponse getAllFriend() {
        return allFriendListService.getAllFriend();
    }
}
