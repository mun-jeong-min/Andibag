package com.example.andibag.domain.notice.present.dto.response;

import com.example.andibag.domain.notice.domain.repository.type.NoticeCategory;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class QueryNoticeResponse {
    private final List<NoticeQueryResponse> noticeQueryResponses;

    @Getter
    @Builder
    public static class NoticeQueryResponse {
        private final Long id;
        private final String nickname;
        private final String title;
        private final String content;
        private final String image;
        private final LocalDateTime createAt;
        private final LocalDateTime modifyAt;
        private final String noticeType;
        private final Boolean isMine;

        @QueryProjection
        public NoticeQueryResponse(Long id, String nickname, String title, String content, String image, LocalDateTime createAt, LocalDateTime modifyAt, String noticeType, Boolean isMine) {
            this.id = id;
            this.nickname = nickname;
            this.title = title;
            this.content = content;
            this.image = image;
            this.createAt = createAt;
            this.modifyAt = modifyAt;
            this.noticeType = noticeType;
            this.isMine = isMine;
        }
    }
}
