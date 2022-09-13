package com.example.andibag.domain.chat.domain;

import com.example.andibag.domain.chat.domain.types.MessageType;
import com.example.andibag.global.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Message extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 512)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private MessageType type;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
}
