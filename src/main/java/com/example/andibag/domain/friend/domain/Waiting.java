package com.example.andibag.domain.friend.domain;

import com.example.andibag.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Waiting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private User userFriend;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private boolean isChecked;

    @Builder
    public Waiting(User user, User userFriend, boolean isChecked) {
        this.user = user;
        this.userFriend = userFriend;
        this.isChecked = isChecked;
    }

    public void updateWaiting(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
