package com.example.andibag.domain.notice.domain;

import com.example.andibag.domain.comment.domain.Comment;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Notice(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void updateNotice(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
