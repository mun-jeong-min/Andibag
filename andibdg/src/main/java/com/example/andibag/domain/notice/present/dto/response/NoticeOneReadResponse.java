package com.example.andibag.domain.notice.present.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NoticeOneReadResponse {
    private String title;
    private String content;
}
