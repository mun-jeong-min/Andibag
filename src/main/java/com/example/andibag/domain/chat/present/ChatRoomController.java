package com.example.andibag.domain.chat.present;

import com.example.andibag.domain.chat.present.dto.response.RoomResponse;
import com.example.andibag.domain.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @PostMapping("/room/{id}")
    public void createRoom(@PathVariable("id") Long friendId) {
        chatRoomService.createRoom(friendId);
    }

    @GetMapping("/room")
    public RoomResponse findAllRoom() {
        return chatRoomService.findAllRoom();
    }

}