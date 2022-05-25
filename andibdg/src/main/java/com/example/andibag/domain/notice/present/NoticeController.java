package com.example.andibag.domain.notice.present;

import com.example.andibag.domain.notice.present.dto.reqeust.NoticeCreateRequest;
import com.example.andibag.domain.notice.present.dto.reqeust.NoticeUpdateRequest;
import com.example.andibag.domain.notice.present.dto.response.NoticeOneReadResponse;
import com.example.andibag.domain.notice.service.NoticeCreateService;
import com.example.andibag.domain.notice.service.NoticeDeleteService;
import com.example.andibag.domain.notice.service.NoticeOneReadService;
import com.example.andibag.domain.notice.service.NoticeUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeOneReadService noticeOneReadService;
    private final NoticeCreateService noticeCreateService;
    private final NoticeUpdateService noticeUpdateService;
    private final NoticeDeleteService noticeDeleteService;

    @GetMapping("/{id}")
    public NoticeOneReadResponse noticeOneRead(@PathVariable("id") Long id) {
        return noticeOneReadService.noticeOneRead(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void noticeCreate(@RequestBody @Valid NoticeCreateRequest request) {
        noticeCreateService.noticeCreate(request);
    }

    @PutMapping("/{id}")
    public void noticeUpdate(@PathVariable("id") Long id, @RequestBody @Valid NoticeUpdateRequest request) {
        noticeUpdateService.updateNotice(id, request);
    }

    @DeleteMapping("/{id}")
    public void noticeDelete(@PathVariable("id") Long id) {
        noticeDeleteService.noticeDelete(id);
    }
}
