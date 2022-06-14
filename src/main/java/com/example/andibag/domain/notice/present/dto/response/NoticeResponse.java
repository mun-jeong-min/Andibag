package com.example.andibag.domain.notice.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class NoticeResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createAt;
    private final LocalDateTime modifyAt;
}
