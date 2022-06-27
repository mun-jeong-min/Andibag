package com.example.andibag.domain.notice.domain.repository.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NoticeCategory {
    FRIEND("friend"),
    NEW("new"),
    GOOD("good");

    private final String name;
}
