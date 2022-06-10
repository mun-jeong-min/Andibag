package com.example.andibag.domain.friend.present;

import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.friend.present.dto.response.FriendAllResponse;
import com.example.andibag.domain.friend.present.dto.response.WaitingListResponse;
import com.example.andibag.domain.friend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/friend")
public class FriendController {
    private final WaitingAddService waitingAddService;
    private final AllFriendListService allFriendReadService;
    private final WaitingCheckService waitingCheckService;
    private final FriendAddService friendAddService;
    private final AllWaitingListService allWaitingListService;

    @PostMapping("/wait")
    public void waitingAdd(@RequestBody @Valid FriendAddRequest request) {
        waitingAddService.friendAdd(request);
    }

    @PatchMapping("/{id}")
    public void waitingTrue(@PathVariable("id") Long id) {
        waitingCheckService.isTrue(id);
    }

    @DeleteMapping("/{id}")
    public void waitingFalse(@PathVariable("id") Long id) {
        waitingCheckService.isFalse(id);
    }

    @PostMapping("/{id}")
    public void addFriend(@PathVariable("id") Long id) {
        friendAddService.AddFriend(id);
    }

    @GetMapping("/fri")
    public FriendAllResponse getAllFriend() {
        return allFriendReadService.getAllFriend();
    }

    @GetMapping("/wait")
    public WaitingListResponse getAllWaiting() {
        return allWaitingListService.WaitingList();
    }
}
