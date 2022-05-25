package com.example.andibag.domain.notice.present.dto.reqeust;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeUpdateRequest {
    private String title;
    private String content;
}
