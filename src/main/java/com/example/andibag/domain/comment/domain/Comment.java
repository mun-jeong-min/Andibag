package com.example.andibag.domain.comment.domain;

import com.example.andibag.domain.notice.domain.Notice;
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
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 150)
    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private Notice notice;

    @NotNull
    @Column
    private Boolean isMine;

    @Builder
    public Comment(String content, User user, Notice notice, Boolean isMine) {
        this.content = content;
        this.user = user;
        this.notice = notice;
        this.isMine = isMine;
    }

    public void updateComment(String content) {
        this.content = content;
    }
}
