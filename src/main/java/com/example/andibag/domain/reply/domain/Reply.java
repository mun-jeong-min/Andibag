package com.example.andibag.domain.reply.domain;

import com.example.andibag.domain.comment.domain.Comment;
import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private Notice notice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column
    private Boolean isMine;

    @Builder
    public Reply(String content, Notice notice, Comment comment, User user, Boolean isMine) {
        this.content = content;
        this.notice = notice;
        this.comment = comment;
        this.user = user;
        this.isMine = isMine;
    }

    public void updateReply(String content) {
        this.content = content;
    }
}
