package com.example.andibag.domain.friend.present;

import com.example.andibag.domain.friend.present.dto.request.FriendAddRequest;
import com.example.andibag.domain.friend.present.dto.request.FriendSearchRequest;
import com.example.andibag.domain.friend.present.dto.response.FriendAllResponse;
import com.example.andibag.domain.friend.present.dto.response.FriendMemoResponse;
import com.example.andibag.domain.friend.present.dto.response.FriendResponse;
import com.example.andibag.domain.friend.service.*;
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
    private final FriendMemoService friendMemoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFriend(@RequestBody @Valid FriendAddRequest request) {
        friendAddService.AddFriend(request);
    }

    @GetMapping
    public FriendAllResponse getAllFriend() {
        return allFriendListService.getAllFriend();
    }

    @GetMapping("/find")
    public FriendResponse findUser(@RequestBody @Valid FriendAddRequest request) {
        return friendSearchService.findUser(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFriend(@PathVariable("id") Long id) {
        friendSearchService.deleteFriend(id);
    }

    @GetMapping("/search")
    public FriendResponse searchFriend(@RequestBody @Valid FriendSearchRequest request) {
        return friendSearchMemoService.friendMemo(request);
    }

    @GetMapping("/memo")
    public FriendMemoResponse memoSearch() {
        return friendMemoService.friendMemo();
    }

    @DeleteMapping("/memo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMemo(@PathVariable("id") Long id) {
        friendMemoService.deleteMemo(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllMemo() {
        friendMemoService.deleteAll();
    }
}
