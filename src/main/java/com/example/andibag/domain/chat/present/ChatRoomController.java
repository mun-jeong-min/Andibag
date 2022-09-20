package com.example.andibag.domain.chat.present;

import com.example.andibag.domain.chat.present.dto.response.EnterRoomResponse;
import com.example.andibag.domain.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @PostMapping("/room/{friendId}")
    public EnterRoomResponse createRoom(@PathVariable("friendId") Long friendId) {
        return chatRoomService.createRoom(friendId);
    }
}