package com.example.andibag.domain.memo.present;

import com.example.andibag.domain.memo.present.dto.response.FriendMemoResponse;
import com.example.andibag.domain.memo.service.FriendMemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@ResponseStatus
@RequestMapping("/memo")
public class MemoController {
    private final FriendMemoService friendMemoService;

    @GetMapping
    public FriendMemoResponse memoReadAll() {
        return friendMemoService.friendMemo();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOne(@PathVariable("id") Long id) {
        friendMemoService.deleteMemo(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMemos() {
        friendMemoService.deleteAll();
    }
}
