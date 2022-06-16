package com.example.andibag.domain.friend.present;

import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.friend.present.dto.response.FriendAllResponse;
import com.example.andibag.domain.friend.service.AllFriendListService;
import com.example.andibag.domain.friend.service.FriendAddService;
import com.example.andibag.domain.friend.service.IdCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/friend")
public class FriendController {
    private final FriendAddService friendAddService;
    private final AllFriendListService allFriendListService;
    private final IdCheckService idCheckService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFriend(@RequestBody @Valid FriendAddRequest request) {
        friendAddService.AddFriend(request);
    }

    @GetMapping
    public FriendAllResponse getAllFriend() {
        return allFriendListService.getAllFriend();
    }

    @PostMapping("/check")
    public void
}
