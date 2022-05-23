package com.example.andibag.domain.user.domain;

import com.example.andibag.global.enums.Authority;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 8, max = 15)
    @Column(unique = true)
    private String accountId;

    @Column
    @Size(max = 60)
    private String password;

    @Column(unique = true)
    private String nickname;

    @NotNull
    @Size(max = 11)
    @Column(unique = true)
    private String phoneNumber;

    @NotNull
    @Column
    private Authority authority;

    @Builder
    public User(String accountId, String password, String nickname, String phoneNumber, Authority authority) {
        this.accountId = accountId;
        this.nickname = nickname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.authority = authority;
    }
}
