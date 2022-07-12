package com.example.andibag.domain.friend.present;

import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.friend.present.dto.request.FriendSearchRequest;
import com.example.andibag.domain.friend.present.dto.response.FriendAllResponse;
import com.example.andibag.domain.friend.present.dto.response.FriendResponse;
import com.example.andibag.domain.friend.service.AllFriendListService;
import com.example.andibag.domain.friend.service.FriendAddService;
import com.example.andibag.domain.friend.service.FriendSearchMemoService;
import com.example.andibag.domain.friend.service.FriendSearchService;
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
    private final FriendSearchService friendSearchService;
    private final FriendSearchMemoService friendSearchMemoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFriend(@RequestBody @Valid FriendAddRequest request) {
        friendAddService.AddFriend(request);
    }

    @GetMapping
    public FriendAllResponse getAllFriend() {
        return allFriendListService.getAllFriend();
    }

    @PostMapping("/find")
    public FriendResponse findUser(@RequestBody @Valid FriendAddRequest request) {
        return friendSearchService.findUser(request);
    }

    @DeleteMapping("/{user-id}/{friend-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFriend(@PathVariable("user-id") Long user_id, @PathVariable("friend-id") Long friend_id) {
        friendSearchService.deleteFriend(user_id, friend_id);
    }

    @PostMapping("/search")
    public FriendResponse searchFriend(@RequestBody @Valid FriendSearchRequest request) {
        return friendSearchMemoService.friendMemo(request);
    }
}
