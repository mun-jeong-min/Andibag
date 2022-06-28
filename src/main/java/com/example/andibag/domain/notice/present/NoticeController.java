package com.example.andibag.domain.notice.present;

import com.example.andibag.domain.notice.domain.repository.type.NoticeCategory;
import com.example.andibag.domain.notice.present.dto.reqeust.NoticeCreateRequest;
import com.example.andibag.domain.notice.present.dto.reqeust.NoticeUpdateRequest;
import com.example.andibag.domain.notice.present.dto.response.QueryNoticeResponse;
import com.example.andibag.domain.notice.service.NoticeAllReadService;
import com.example.andibag.domain.notice.service.NoticeCreateService;
import com.example.andibag.domain.notice.service.NoticeDeleteService;
import com.example.andibag.domain.notice.service.NoticeUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeCreateService noticeCreateService;
    private final NoticeUpdateService noticeUpdateService;
    private final NoticeDeleteService noticeDeleteService;
    private final NoticeAllReadService noticeAllReadService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void noticeCreate(@RequestBody @Valid NoticeCreateRequest request) {
        noticeCreateService.noticeCreate(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void noticeUpdate(@PathVariable("id") Long id, @RequestBody @Valid NoticeUpdateRequest request) {
        noticeUpdateService.updateNotice(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void noticeDelete(@PathVariable("id") Long id) {
        noticeDeleteService.noticeDelete(id);
    }

    @GetMapping("/{category}")
    public QueryNoticeResponse noticeList(@PathVariable("category") NoticeCategory category) {
        return noticeAllReadService.noticeAllRead(category);
    }
}
