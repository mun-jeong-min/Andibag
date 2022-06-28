package com.example.andibag.domain.notice.service;

import com.example.andibag.domain.notice.domain.repository.NoticeRepository;
import com.example.andibag.domain.notice.domain.repository.type.NoticeCategory;
import com.example.andibag.domain.notice.present.dto.response.QueryNoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeAllReadService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public QueryNoticeResponse noticeAllRead(NoticeCategory category) {
        List<QueryNoticeResponse.NoticeQueryResponse> noticeList = noticeRepository.findNoticesByNoticeType(category)
                .stream().map(notice -> QueryNoticeResponse.NoticeQueryResponse.builder()
                        .id(notice.getId())
                        .title(notice.getTitle())
                        .content(notice.getContent())
                        .createAt(notice.getCreateTime())
                        .modifyAt(notice.getModifyTime())
                        .noticeType(notice.getNoticeType().getName())
                        .isMine(notice.getIsMine())
                        .build()
                )
                .collect(Collectors.toList());

        return new QueryNoticeResponse(noticeList);
    }
}
