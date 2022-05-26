package com.example.andibag.domain.notice.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class NoticeAllReadResponse {
    private final List<NoticeResponse> noticeList;
}
