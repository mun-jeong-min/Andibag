package com.example.andibag.domain.comment.domain;

import com.example.andibag.domain.notice.domain.Notice;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Notice_Id")
    private Notice notice;

    @Builder
    public Comment(String content) {
        this.content = content;
    }

    public void updateComment(String content) {
        this.content = content;
    }
}
