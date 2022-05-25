package com.example.andibag.domain.notice.present;

import com.example.andibag.domain.notice.present.dto.reqeust.NoticeCreateRequest;
import com.example.andibag.domain.notice.present.dto.response.NoticeOneReadResponse;
import com.example.andibag.domain.notice.service.NoticeCreateService;
import com.example.andibag.domain.notice.service.NoticeOneReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeOneReadService noticeOneReadService;
    private final NoticeCreateService noticeCreateService;

    @GetMapping("/{id}")
    public NoticeOneReadResponse noticeOneRead(@PathVariable("id") Long id) {
        return noticeOneReadService.noticeOneRead(id);
    }

    @PostMapping
    public void noticeCreate(@RequestBody @Valid NoticeCreateRequest request) {
        noticeCreateService.noticeCreate(request);
    }
}
