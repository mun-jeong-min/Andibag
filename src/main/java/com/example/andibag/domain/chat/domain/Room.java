package com.example.andibag.domain.chat.domain;

import com.example.andibag.domain.friend.domain.Friend;
import com.example.andibag.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_user")
    private User headUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private User friend;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.REMOVE)
    private final Set<Member> member = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.REMOVE)
    private final Set<Message> messages = new HashSet<>();

    @Builder
    public Room(User headUser, User friend) {
        this.headUser = headUser;
        this.friend = friend;
    }
}
