package com.example.andibag.domain.notice.domain;

import com.example.andibag.domain.notice.domain.repository.type.NoticeCategory;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Notice extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 20)
    @Column
    private String title;

    @NotNull
    @Column
    private String content;

    @Column
    private String imageUrl;

    @NotNull
    @Enumerated(EnumType.STRING)
    private NoticeCategory noticeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column
    private Boolean isMine;

    @Builder
    public Notice(
            String title,
            String content,
            String imageUrl,
            User user,
            NoticeCategory noticeType,
            Boolean isMine
    ){
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.user = user;
        this.noticeType = noticeType;
        this.isMine = isMine;
    }

    public void updateNotice(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
